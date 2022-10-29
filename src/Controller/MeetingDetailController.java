/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Entite.Meeting;
import Entite.Project;
import Service.MeetingService;
import Service.ProjectService;
import Service.ServiceDailyScrum;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
public class MeetingDetailController implements Initializable {
    @FXML
    private Pane pane;
    @FXML
    private Text title;
    @FXML
    private Text goal;
    @FXML
    private Text issues;
    @FXML
    private Text type;
    @FXML
    private Text date;
    @FXML
    private Text time;
    @FXML
    private Text duration;
    @FXML
    private Text location;
    @FXML
    private Text organizedBy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        



    }    

    @FXML
    private void exit(ActionEvent event) {
         Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
     public void sendText(String reciveTitle) throws SQLException {


        System.out.println(reciveTitle);
        //title.setText(reciveTitle);
        
        MeetingService  sd = new MeetingService ();
        Meeting d = sd.readMeeting(reciveTitle);
        System.out.println(d.toString());
            
     
        title.setText(d.getTitle());
        goal.setText(d.getGoal());
        issues.setText(d.getIssues());
        type.setText(d.getType());
        date.setText(d.getDate());
        time.setText(d.getTime());
        duration.setText(d.getDuration());
        location.setText(d.getLocation());
        organizedBy.setText(d.getOrganizedBy());
      

    }


}
