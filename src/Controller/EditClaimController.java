/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.MeetingClaim;
import Service.MeetingClaimService;
import Utils.TrayIconDemo;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EditClaimController implements Initializable {
    @FXML
    private Pane paneClaim;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField other;
    @FXML
    private TextField reason;
    @FXML
    private Button back;
    private     MeetingClaim    selectedRM;

    /**
     * Initializes the controller class.
     */
    
     void Data(MeetingClaim m) {

        email.setText(m.getEmail());
        reason.setText(m.getReason());
        other.setText(m.getOther());
        phone.setText(m.getTel());
        selectedRM = new MeetingClaim(m.getId(), m.getEmail(),m.getTel(),m.getOther(),m.getReason());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Cancel(ActionEvent event) {
         Stage stage = (Stage) paneClaim.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Edit(ActionEvent event) throws IOException {
        
           MeetingClaimService ps = new MeetingClaimService();
        selectedRM.setEmail(email.getText());
        selectedRM.setTel(phone.getText());
        selectedRM.setOther(other.getText());
        selectedRM.setReason(reason.getText());
        ps.EditClaim(selectedRM);

         if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.EditClaimTray();
                } catch (AWTException ex) {
                    Logger.getLogger(MeetingClaimService.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
        
    }
    
}
