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
import Service.UserService;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class NewClaimController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField lastname;
    @FXML
    private TextField reason;
    @FXML
    private TextField other;
    @FXML
    private DatePicker date;
    @FXML
    private Button save;
    @FXML
    private ComboBox<Integer> meeting;
    @FXML
    private TextField phone;
    @FXML
    private ComboBox<String> available;
    @FXML
    private ComboBox<Integer> user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        available.getItems().addAll("i'm not Available", "i will be late", "i'm sick");
        available.getSelectionModel().select("");

        MeetingClaimService PS = new MeetingClaimService();

        ArrayList arrayList = (ArrayList) PS.selectTitle();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        meeting.setItems(observableList);

        UserService US = new UserService();

        ArrayList arrayList1 = (ArrayList) US.selectName();
        ObservableList observableList1 = FXCollections.observableArrayList(arrayList1);
        user.setItems(observableList1);

        System.out.println(observableList1);

    }

    @FXML
    private void save(ActionEvent event) {

        String d = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        if ( name.getText().isEmpty()||lastname.getText().isEmpty() || phone.getText().isEmpty() || email.getText().isEmpty() || other.getText().isEmpty() || reason.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter values !!!");
            alert.show(); 
        }
        MeetingClaim p = new MeetingClaim(user.getSelectionModel().getSelectedIndex() + 1,name.getText(), lastname.getText(), email.getText(),phone.getText(), meeting.getSelectionModel().getSelectedIndex() + 1,d,available.getSelectionModel().getSelectedItem(), other.getText(), reason.getText());
        MeetingClaimService SMService = new MeetingClaimService();
        SMService.insert(p);

               if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.AddClaimTray();
                } catch (AWTException ex) {
                    Logger.getLogger(MeetingClaimService.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    }

}
