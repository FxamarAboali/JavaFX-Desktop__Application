/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Affect;
import Entite.Meeting;
import Entite.User;
import Service.AffectService;
import Service.MeetingService;
import Service.UserService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AffectMeetingController implements Initializable {
    @FXML
    private ComboBox<User> user;
    @FXML
    private ComboBox<Meeting> meeting;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         
        MeetingService MS= new MeetingService();     

        ArrayList arrayList = (ArrayList) MS.selectTitle();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
         meeting.setItems(observableList);

     
          UserService US= new UserService();     

        ArrayList arrayList1 = (ArrayList) US.selectName();
        ObservableList observableList1 = FXCollections.observableArrayList(arrayList1);
         user.setItems(observableList1);

    }    

    @FXML
    private void CreateNewMeeting(ActionEvent event) {
    
        Affect p = new Affect(meeting.getSelectionModel().getSelectedIndex()+1,user.getSelectionModel().getSelectedIndex()+1);
        AffectService SMService = new AffectService();
        SMService.AffectUser(p);

        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
        
    }
    
}
