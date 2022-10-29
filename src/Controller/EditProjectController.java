/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Project;
import Service.ProjectService;
import Utils.TrayIconDemo;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EditProjectController implements Initializable {

    @FXML
    private Pane paneProject;
    @FXML
    private TextField name;
    @FXML
    private TextField description;
    @FXML
    private Button back;
    private Project selectedP;
    @FXML
    private DatePicker deadline;

    private String selected_item;
    @FXML
    private TextField category;
    @FXML
    private TextField version;

    /**
     * Initializes the controller class.
     */
    void Data(Project p) {

        name.setText(p.getTitle());
        description.setText(p.getDescription());

        selectedP = new Project(p.getId(), p.getTitle(), p.getDescription());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Cancel(ActionEvent event) {
        Stage stage = (Stage) paneProject.getScene().getWindow();
        stage.close();
    }

    public void sendText(String reciveTitle) throws SQLException {
        this.selected_item = reciveTitle;

    }

    @FXML
    private void Edit(ActionEvent event) {

        ProjectService ps = new ProjectService();
        selectedP.setTitle(name.getText());
        selectedP.setDescription(description.getText());
        selectedP.setDeadline(deadline.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        selectedP.setCategory(category.getText());
        selectedP.setVersion(Integer.parseInt(version.getText()));
        ps.updateProject(selectedP);

        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            try {
                td.EditProjectTray(name.getText());
            } catch (AWTException ex) {
                Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("System tray not supported!");
        }

    }

}
