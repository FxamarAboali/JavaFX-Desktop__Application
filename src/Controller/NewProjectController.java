/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Project;
import Service.MeetingService;
import Service.ProjectService;
import Utils.TrayIconDemo;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class NewProjectController implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField description;
    @FXML
    private DatePicker deadline;
    @FXML
    private TextField version;
    @FXML
    private TextField category;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    
    }    

    @FXML
    private void CreateNewProject(ActionEvent event) {  
        
                    int versionn = Integer.parseInt(version.getText());

        String d = deadline.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (name.getText().isEmpty() || description.getText().isEmpty() ||category.getText().isEmpty() || version.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter values !!!");
            alert.show();
        }

        Project p = new Project(name.getText(), description.getText(), d,category.getText(),versionn);
        ProjectService projectService = new ProjectService();
        projectService.insert(p);
   if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            try {
                td.AddProjectTray(name.getText());
            } catch (AWTException ex) {
                Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("System tray not supported!");
        }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    }
    
}
