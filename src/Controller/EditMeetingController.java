/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Meeting;
import Service.MeetingService;
import Utils.TrayIconDemo;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EditMeetingController implements Initializable {
     @FXML
    private TextField title;
    @FXML
    private TextField issues;
    @FXML
    private TextField goal;
    @FXML
    private TextField location;
    private TextField duration;
    @FXML
    private Pane paneMeeting;

    Meeting selectedRM;
    @FXML
    private Button back;
        private String selected_item;



    /**
     * Initializes the controller class.
     */
    
     void Data(Meeting m) {

        title.setText(m.getTitle());
        goal.setText(m.getGoal());
        issues.setText(m.getIssues());
        location.setText(m.getLocation());
        selectedRM = new Meeting(m.getId(), m.getTitle(), m.getGoal(),m.getIssues(), m.getLocation());
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Edit(ActionEvent event) {
        
       
        MeetingService ps = new MeetingService();
        selectedRM.setTitle(title.getText());
        selectedRM.setGoal(goal.getText());
        selectedRM.setIssues(issues.getText());
        selectedRM.setLocation(location.getText());
        
         ps.EditMeeting(selectedRM);
        
         if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.EditMeetingTray(title.getText());
                } catch (AWTException ex) {
                    Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    }
    
   

    @FXML
    private void Cancel(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) paneMeeting.getScene().getWindow();
        stage.close();
    }
    
}
