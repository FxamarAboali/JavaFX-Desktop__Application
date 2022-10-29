/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.SprintRetrospective;
import Service.ServiceSprintRetro;
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
public class RetrospectiveModifyController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private JFXTextField titled;
    @FXML
    private JFXTextArea Startd;
    @FXML
    private JFXTextArea Stopd;
    @FXML
    private JFXTextArea continued;
    
    private String selected_item;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) throws SQLException {
         ServiceSprintRetro ser = new ServiceSprintRetro();

        if (titled.getText().isEmpty() || Startd.getText().isEmpty() || Stopd.getText().isEmpty() || continued.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in your fields");
            alert.show();
        } else if (ser.isExiste(titled.getText())) {
            // System.out.println("true");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(titled.getText() + " file already exists !");
            alert.show();
        } else {
            SprintRetrospective p = new SprintRetrospective(titled.getText(), Startd.getText(), Stopd.getText(), continued.getText());

            //System.out.println(p.toString());

            ser.updateRetro(p,selected_item);

            new Alert(Alert.AlertType.INFORMATION, "sucess").show();
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
    
      public void sendText(String reciveTitle) throws SQLException {
         this.selected_item = reciveTitle;
         
     }
}
