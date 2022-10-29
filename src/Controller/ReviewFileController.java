/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class ReviewFileController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private JFXTextField titled;
    @FXML
    private JFXTextArea pname;
    @FXML
    private JFXTextArea thingst;
    @FXML
    private JFXTextArea quickup;
    @FXML
    private JFXTextArea whatis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
}
