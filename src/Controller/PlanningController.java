/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Entite.Planning;
import Service.ServiceDailyScrum;
import Service.ServicePlanning;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import trash.HomeController;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class PlanningController implements Initializable {

    @FXML
    private TableView<Planning> tableview1;
    @FXML
    private TableColumn<Planning, String> name;
    @FXML
    private TableColumn<Planning, String> dcreation;
    @FXML
    private TableColumn<Planning, String> tcreation;
    @FXML
    private TableColumn<Planning, String> dmodify;
    @FXML
    private TableColumn<Planning, String> tmodify;

    @FXML
    private TextField filterField;

    private final ObservableList<Planning> aff = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Planning, String> username;

    public String sendTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afiiche();
        } catch (SQLException ex) {
            Logger.getLogger(PlanningController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afiiche() throws SQLException {

        ServicePlanning ser = new ServicePlanning();
        List<Planning> lus = ser.readAllPlan();

        aff.addAll(lus);
        tableview1.setItems(aff);

        name.setCellValueFactory(new PropertyValueFactory<Planning, String>("title"));
        dcreation.setCellValueFactory(new PropertyValueFactory<Planning, String>("date_creation"));
        tcreation.setCellValueFactory(new PropertyValueFactory<Planning, String>("time_creation"));
        dmodify.setCellValueFactory(new PropertyValueFactory<Planning, String>("date_modification"));
        tmodify.setCellValueFactory(new PropertyValueFactory<Planning, String>("time_modification"));
        username.setCellValueFactory(new PropertyValueFactory<Planning, String>("createdby"));

//        
//        System.out.print(idd);
    }

    public void filter(ObservableList<Planning> list) {

        FilteredList<Planning> filteredData = new FilteredList<>(list, b -> true);

// 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Planning -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Planning.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (Planning.getCreatedby().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } /*else if (String.valueOf(DailyScrum.getSalary()).indexOf(lowerCaseFilter) != -1) {
        return true;
        } */ else {
                    return false; // Does not match.
                }
            });
        });

        SortedList<Planning> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableview1.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableview1.setItems(sortedData);
    }

    @FXML
    private void FiltredDisplay(ActionEvent event) {
        filter(aff);
    }

    @FXML
    private void view(ActionEvent event) throws SQLException {

        String sendTitle = tableview1.getSelectionModel().getSelectedItem().getTitle();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/PlanningView.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(PlanningViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        PlanningViewController y = loader.getController();
        y.sendText(sendTitle);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @FXML
    private void modify(ActionEvent event) throws SQLException {

        sendTitle = tableview1.getSelectionModel().getSelectedItem().getTitle();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/PlanningModify.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(PlanningController.class.getName()).log(Level.SEVERE, null, ex);
        }

        PlanningModifyController y = loader.getController();
        y.sendText(sendTitle);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {

        ServicePlanning sp = new ServicePlanning();
        sp.deletePlanning((Planning) tableview1.getSelectionModel().getSelectedItem());
        tableview1.getItems().remove(tableview1.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void deleteAll(ActionEvent event) throws SQLException {

        ServicePlanning sp = new ServicePlanning();
        sp.deleteAllPlan();
        tableview1.refresh();
    }

    @FXML
    private void pdf(ActionEvent event) {
    }

}
