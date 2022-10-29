/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Entite.Planning;
import Service.ServiceDailyScrum;
import Service.ServicePlanning;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class PlanningModifyController implements Initializable {

    @FXML
    private JFXTextField titled;
    @FXML
    private JFXTextArea analyse;
    @FXML
    private JFXTextArea evaluate;
    @FXML
    private JFXTextArea product;
    @FXML
    private JFXTextField sprint;
    @FXML
    private JFXTextField task;

    
    private String selected_item;
    @FXML
    private Pane pane;
    

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

    @FXML
    private void save(ActionEvent event) throws SQLException {
        
         if (titled.getText().isEmpty() || analyse.getText().isEmpty() || evaluate.getText().isEmpty() || product.getText().isEmpty() || sprint.getText().isEmpty() || task.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez saisir vos champs");
            alert.show();
        } else {

          
            Planning p = new Planning(titled.getText(), analyse.getText(), evaluate.getText(), product.getText(),sprint.getText(),task.getText());

            //System.out.println(p.toString());

             ServicePlanning ser = new ServicePlanning();
             ser.updatePlan(p, selected_item);

            new Alert(Alert.AlertType.INFORMATION, "Update sucess").show();

        }
    }
    
      public void sendText(String reciveTitle) throws SQLException {
         this.selected_item = reciveTitle;
         
     }

    

}
