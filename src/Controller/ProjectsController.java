/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Meeting;
import Entite.Project;
import Service.MeetingClaimService;
import Service.MeetingService;
import Service.ProjectService;
import Utils.ProjectPDF;
import Utils.TrayIconDemo;
import com.lowagie.text.DocumentException;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
 * @author Lenovo
 */
public class ProjectsController implements Initializable {

    @FXML
    private TableView<Project> projects;
    @FXML
    private TableColumn<Project, String> description;
    @FXML
    private TextField filterField;
    public String sendName;
    private final ObservableList<Project> aff = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Project, String> date;
    @FXML
    private TableColumn<Project, String> time;
    @FXML
    private TableColumn<Project, String> deadline;
    @FXML
    private TableColumn<Project, String> title;
    public String sendTitle;
    @FXML
    private TableColumn<Project, String> category;
    @FXML
    private TableColumn<Project, Integer> version;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ProjectService ser = new ProjectService();
        List<Project> lus = ser.selectAll();
        aff.addAll(lus);
        projects.getItems().clear();
        projects.setItems(aff);
        title.setCellValueFactory(new PropertyValueFactory<Project, String>("ProjectTitle"));
        description.setCellValueFactory(new PropertyValueFactory<Project, String>("description"));
        date.setCellValueFactory(new PropertyValueFactory<Project, String>("date_creation"));
        time.setCellValueFactory(new PropertyValueFactory<Project, String>("time_creation"));
        deadline.setCellValueFactory(new PropertyValueFactory<Project, String>("deadline"));
        category.setCellValueFactory(new PropertyValueFactory<Project, String>("category"));
        version.setCellValueFactory(new PropertyValueFactory<Project, Integer>("version"));

    }

    @FXML
    private void FiltredDisplay(ActionEvent event) {
    }

    @FXML
    private void open(ActionEvent event) throws SQLException {
        

        sendName = projects.getSelectionModel().getSelectedItem().getTitle();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/ProjectView.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ProjectViewController y = loader.getController();
        y.sendText(sendName);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

    @FXML
    private void modifyPRoject(ActionEvent event) throws IOException, SQLException {

        sendTitle = projects.getSelectionModel().getSelectedItem().getTitle();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/EditProject.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        EditProjectController y = loader.getController();
        y.Data((Project) projects.getSelectionModel().getSelectedItem());

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

    @FXML
    private void deleteProject(ActionEvent event) {
        ProjectService sd = new ProjectService();
        sd.deleteProject((Project) projects.getSelectionModel().getSelectedItem());
        projects.getItems().remove(projects.getSelectionModel().getSelectedItem());

        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            try {
                td.DeleteProjectTray(title.getText());
            } catch (AWTException ex) {
                Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("System tray not supported!");
        }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    }

    @FXML
    private void deleteAllProjects(ActionEvent event) {
        ProjectService sd = new ProjectService();
        sd.deleteAllProjects();
        projects.refresh();

        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            try {
                td.DeleteAllProjectsTray();
            } catch (AWTException ex) {
                Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("System tray not supported!");
        }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    }

    @FXML
    private void pdfProject(ActionEvent event) throws SQLException, IOException {

        ProjectPDF pdf = new ProjectPDF();

        try {
            pdf.listProjects();
        } catch (DocumentException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
