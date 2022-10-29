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
import javafx.scene.layout.BorderPane;
import trash.HomeController;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MeetingController extends ServiceGenerateWindow implements Initializable {
    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DailyScrumDisplay(ActionEvent event) {
        
                super.loadUI("/Gui/DailyMeeting",borderpane);

    }


    @FXML
    private void RetrospectiveDisplay(ActionEvent event) {
                super.loadUI("/Gui/RetrospectiveMeeting",borderpane);

    }

    @FXML
    private void ReviewDisplay(ActionEvent event) {
                super.loadUI("/Gui/ReviewMeeting",borderpane);

    }

    @FXML
    private void createNewMeeting(ActionEvent event) {
                super.loadUI("/Gui/NewMeeting",borderpane);

    }

    @FXML
    private void SprintDisplay(ActionEvent event) {
                super.loadUI("/Gui/SprintMeeting",borderpane);

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
    private void AffectUser(ActionEvent event) {
        
                        super.loadUI("/Gui/AffectMeeting",borderpane);

    }

}
