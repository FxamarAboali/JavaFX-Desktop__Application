/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Meeting;
import Entite.User;
import Service.MeetingClaimService;
import Service.MeetingService;
import Service.ProjectService;
import Utils.TrayIconDemo;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class NewMeetingController implements Initializable {
     @FXML
    private TextField title;
    @FXML
    private TextField issues;
    @FXML
    private TextField goal;
    @FXML
    private DatePicker date;
    @FXML
    private TextField time;
    @FXML
    private ComboBox<String> type;
    @FXML
    private ComboBox<Integer> project;
    @FXML
    private TextField location;
    private String review="4Hours";
    private String daily="15mn";
    private String retrospective="1H50";
    private String sprint="2Hours";
    private String organizedBy="Ahmed_BenAhmed";
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          type.getItems().addAll("Daily", "Retrospective", "Review", "Sprint");
        type.getSelectionModel().select("");

        ProjectService PS = new ProjectService();

        ArrayList arrayList = (ArrayList) PS.selectTitle();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        project.setItems(observableList);

        System.out.println(observableList);
    }    

     @FXML
    private void CreateNewMeeting(ActionEvent event ) throws AWTException {
        
         String d = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (title.getText().isEmpty() || goal.getText().isEmpty() || issues.getText().isEmpty() || type.getSelectionModel().isEmpty() ||  location.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter values !!!");
            alert.show();
    
        }
        
        
        if (type.getSelectionModel().equals("Review")){
         Meeting p = new Meeting(title.getText(), goal.getText(), issues.getText(), project.getSelectionModel().getSelectedIndex()+1, type.getSelectionModel().getSelectedItem(), d, time.getText(), review, location.getText(),organizedBy);
        MeetingService SMService = new MeetingService();
        SMService.insert(p);
         if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.AddMeetingTray(title.getText());
        } else {
            System.err.println("System tray not supported!");
        }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    
        
        

        }else if(type.getSelectionModel().equals("Daily")){
             Meeting p = new Meeting(title.getText(), goal.getText(), issues.getText(), project.getSelectionModel().getSelectedIndex()+1, type.getSelectionModel().getSelectedItem(), d, time.getText(), daily, location.getText(),organizedBy);
        MeetingService SMService = new MeetingService();
        SMService.insert(p);

        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
            
        }else if(type.getSelectionModel().equals("retrospective")){
             Meeting p = new Meeting(title.getText(), goal.getText(), issues.getText(), project.getSelectionModel().getSelectedIndex()+1, type.getSelectionModel().getSelectedItem(), d, time.getText(), retrospective, location.getText(),organizedBy);
        MeetingService SMService = new MeetingService();
        SMService.insert(p);

        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
            
        }else{
                     Meeting p = new Meeting(title.getText(), goal.getText(), issues.getText(), project.getSelectionModel().getSelectedIndex()+1, type.getSelectionModel().getSelectedItem(), d, time.getText(), sprint, location.getText(),organizedBy);
        MeetingService SMService = new MeetingService();
        SMService.insert(p);

        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
        }
        
    }


}
