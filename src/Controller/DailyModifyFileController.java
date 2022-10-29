/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Service.ServiceDailyScrum;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class DailyModifyFileController implements Initializable {

    @FXML
    private Pane panedaily;
    @FXML
    private JFXTextField titled;
    @FXML
    private JFXTextArea workyesterday;
    @FXML
    private JFXTextArea todayplan;
    @FXML
    private JFXTextArea workblock;
    @FXML
    private JFXTextField brunthrs;
    @FXML
    private JFXTextField hrscomplt;
    
    private String selected_item;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveDaillyScrum(ActionEvent event) throws SQLException {
        
        if (titled.getText().isEmpty() || workyesterday.getText().isEmpty() || todayplan.getText().isEmpty() || workblock.getText().isEmpty() || brunthrs.getText().isEmpty() || hrscomplt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez saisir vos champs");
            alert.show();
        } else {

            int hbrunt = Integer.parseInt(brunthrs.getText());
            int hcompl = Integer.parseInt(hrscomplt.getText());
            DailyScrum d = new DailyScrum(titled.getText(), workyesterday.getText(), todayplan.getText(), workblock.getText(), hbrunt, hcompl);

            //System.out.println(d.toString());

            ServiceDailyScrum ser = new ServiceDailyScrum();
            ser.updateDaily(d,selected_item);

            new Alert(Alert.AlertType.INFORMATION, "Update sucess").show();

        }
    }
    
     public void sendText(String reciveTitle) throws SQLException {
         this.selected_item = reciveTitle;
         
     }

    @FXML
    private void exit(ActionEvent event) {
         Stage stage = (Stage) panedaily.getScene().getWindow();
        stage.close();
    }
    
}
