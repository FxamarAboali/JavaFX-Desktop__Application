/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Service.ServiceDailyScrum;
import Service.ServiceGenerateWindow;
import Utils.PDFDailyScrum;
import com.lowagie.text.DocumentException;
import java.io.FileNotFoundException;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class DailyScrumController extends ServiceGenerateWindow implements Initializable {

    private double xOffset, yOffset;

    @FXML
    private TableView<DailyScrum> tableview1;
    @FXML
    private TableColumn<DailyScrum, String> name;
    @FXML
    private TableColumn<DailyScrum, String> dcreation;
    @FXML
    private TableColumn<DailyScrum, String> tcreation;
    @FXML
    private TableColumn<DailyScrum, String> dmodify;
    @FXML
    private TableColumn<DailyScrum, String> tmodify;

    @FXML
    private TextField filterField;

    private final ObservableList<DailyScrum> aff = FXCollections.observableArrayList();

    public String sendTitle;
    @FXML
    private TableColumn<DailyScrum, String> username;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            display();
        } catch (SQLException ex) {
            Logger.getLogger(DailyScrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void display() throws SQLException {
        ServiceDailyScrum ser = new ServiceDailyScrum();

        List<DailyScrum> lus = ser.readAllDaily();

        aff.addAll(lus);
        tableview1.getItems().clear();
        tableview1.setItems(aff);

        name.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("title"));
        dcreation.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("date_creation"));
        tcreation.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("time_creation"));
        dmodify.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("date_modification"));
        tmodify.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("time_modification"));
        username.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("createdby"));

    }

    public void filter(ObservableList<DailyScrum> list) {

        FilteredList<DailyScrum> filteredData = new FilteredList<>(list, b -> true);

// 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(DailyScrum -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (DailyScrum.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } /*else if (DailyScrum.getDate_creation().indexOf(lowerCaseFilter) != -1) {
        return true; // Filter matches last name.
        } else if (String.valueOf(DailyScrum.getSalary()).indexOf(lowerCaseFilter) != -1) {
        return true;
        } */ else {
                    return false; // Does not match.
                }
            });
        });

        SortedList<DailyScrum> sortedData = new SortedList<>(filteredData);

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
    private void deleteAllDaily(ActionEvent event) throws SQLException {
        ServiceDailyScrum sd = new ServiceDailyScrum();
        sd.deleteAllDaily();
        tableview1.refresh();

    }

    @FXML
    private void deleteDailyS(ActionEvent event) throws SQLException {
        ServiceDailyScrum sd = new ServiceDailyScrum();
        sd.deleteDaily((DailyScrum) tableview1.getSelectionModel().getSelectedItem());
        tableview1.getItems().remove(tableview1.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void openDailyS(ActionEvent event) throws SQLException {

        sendTitle = tableview1.getSelectionModel().getSelectedItem().getTitle(); // newWindow("DailyViewFile");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/DailyViewFile.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DailyScrumController.class.getName()).log(Level.SEVERE, null, ex);
        }

        DailyViewFileController y = loader.getController();
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
    private void modifyDailyS(ActionEvent event) throws IOException, SQLException {

        sendTitle = tableview1.getSelectionModel().getSelectedItem().getTitle(); 
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/DailyModifyFile.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DailyScrumController.class.getName()).log(Level.SEVERE, null, ex);
        }

        DailyModifyFileController y = loader.getController();
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
    private void pdfDaily(ActionEvent event) throws SQLException, IOException, FileNotFoundException, DocumentException {
        
        PDFDailyScrum pdf = new PDFDailyScrum();
        
                pdf.listActivite();
         
    }

    


}
