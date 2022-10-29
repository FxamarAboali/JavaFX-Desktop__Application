/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Meeting;
import Entite.MeetingClaim;
import Service.MeetingClaimService;
import Service.MeetingService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MeetingClaimDetailController implements Initializable {
    @FXML
    private Pane pane;
    @FXML
    private Text name;
    @FXML
    private Text lastname;
    @FXML
    private Text phone;
    @FXML
    private Text email;
    @FXML
    private Text meeting;
    @FXML
    private Text available;
    @FXML
    private Text other;
    @FXML
    private Text reason;
        public String reciveid;
    @FXML
    private Text date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void sendText(int reciveid) throws SQLException {


        System.out.println(reciveid);
        //title.setText(reciveTitle);
        
        MeetingClaimService  sd = new MeetingClaimService ();
        MeetingClaim d = sd.readClaim(reciveid);
        System.out.println(d.toString());
            
     
        name.setText(d.getName());
        lastname.setText(d.getLastname());
        phone.setText(d.getTel());
        email.setText(d.getEmail());
//        meeting.setText();
        available.setText(d.getAvailable());
        date.setText(d.getDate());
        other.setText(d.getOther());
        reason.setText(d.getReason());
      

    }

 
 
    @FXML
    private void exit(ActionEvent event) {
        
                Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

  
    
}
