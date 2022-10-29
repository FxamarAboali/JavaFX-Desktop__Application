/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Planning;
import Entite.SprintRetrospective;
import Service.ServicePlanning;
import Service.ServiceSprintRetro;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class RetrospectiveController implements Initializable {

    @FXML
    private TableView<SprintRetrospective> tableview1;
    @FXML
    private TableColumn<SprintRetrospective, String> name;
    @FXML
    private TableColumn<SprintRetrospective, String> dcreation;
    @FXML
    private TableColumn<SprintRetrospective, String> tcreation;
    @FXML
    private TableColumn<SprintRetrospective, String> dmodify;
    @FXML
    private TableColumn<SprintRetrospective, String> tmodify;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<SprintRetrospective, String> username;
    public String sendTitle;

    private final ObservableList<SprintRetrospective> aff = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            affiche();
        } catch (SQLException ex) {
            Logger.getLogger(RetrospectiveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void affiche() throws SQLException {
        ServiceSprintRetro ser = new ServiceSprintRetro();
        List<SprintRetrospective> lus = ser.readAllRetro();

        aff.addAll(lus);
        tableview1.setItems(aff);

        name.setCellValueFactory(new PropertyValueFactory<SprintRetrospective, String>("title"));
        dcreation.setCellValueFactory(new PropertyValueFactory<SprintRetrospective, String>("date_creation"));
        tcreation.setCellValueFactory(new PropertyValueFactory<SprintRetrospective, String>("time_creation"));
        dmodify.setCellValueFactory(new PropertyValueFactory<SprintRetrospective, String>("date_modification"));
        tmodify.setCellValueFactory(new PropertyValueFactory<SprintRetrospective, String>("time_modification"));
        username.setCellValueFactory(new PropertyValueFactory<SprintRetrospective, String>("createdby"));
    }

    @FXML
    private void FiltredDisplay(ActionEvent event) {
    }

    @FXML
    private void view(ActionEvent event) throws SQLException {
        sendTitle = tableview1.getSelectionModel().getSelectedItem().getTitle();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/RetrospectiveView.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RetrospectiveController.class.getName()).log(Level.SEVERE, null, ex);
        }

        RetrospectiveViewController y = loader.getController();
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
        loader.setLocation(getClass().getResource("/Gui/RetrospectiveModify.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RetrospectiveController.class.getName()).log(Level.SEVERE, null, ex);
        }

        RetrospectiveModifyController y = loader.getController();
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

        ServiceSprintRetro sr = new ServiceSprintRetro();
        sr.deleteRetro((SprintRetrospective) tableview1.getSelectionModel().getSelectedItem());
        tableview1.getItems().remove(tableview1.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void deleteAll(ActionEvent event) throws SQLException {

        ServiceSprintRetro sr = new ServiceSprintRetro();
        sr.deleteAllRetro();
        tableview1.refresh();
    }

    @FXML
    private void pdf(ActionEvent event) {
    }

}
