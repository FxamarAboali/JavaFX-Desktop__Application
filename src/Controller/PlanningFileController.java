/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Planning;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class PlanningFileController implements Initializable {

    @FXML
    private JFXTextField titled;
    @FXML
    private JFXTextArea analyse;
    @FXML
    private JFXTextArea evaluate;
    @FXML
    private JFXTextArea product;
    @FXML
    private JFXTextArea sprint;
    @FXML
    private JFXTextArea task;
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
           ServicePlanning ser = new ServicePlanning();

        if (titled.getText().isEmpty() || analyse.getText().isEmpty() || evaluate.getText().isEmpty() || product.getText().isEmpty() || sprint.getText().isEmpty() || task.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in your fields");
            alert.show();
        } else if (ser.isExiste(titled.getText())){
           // System.out.println("true");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText( titled.getText() +" file already exists !");
            alert.show();
        } else{
            Planning p = new Planning(titled.getText(), analyse.getText(), evaluate.getText(), product.getText(), sprint.getText(), task.getText());

            System.out.println(p.toString());

            
           ser.ajouterDoc(p);

            new Alert(Alert.AlertType.INFORMATION, "sucess").show();

        }

    }

}
