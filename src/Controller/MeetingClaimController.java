/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.ServiceGenerateWindow;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import trash.HomeController;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MeetingClaimController extends ServiceGenerateWindow implements Initializable {
    @FXML
    private BorderPane borderpane;
    @FXML
    private Button newClaim;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void createNewClaim(ActionEvent event) {
        
        loadUI("/Gui/NewClaim");
    }
    
     private void loadUI(String ui) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderpane.setCenter(root);

    }

    @FXML
    private void AllClaims(ActionEvent event) {
        
                        super.loadUI("/Gui/Claims",borderpane);

    }
    
}
