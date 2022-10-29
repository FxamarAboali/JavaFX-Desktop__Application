/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.User;
import Service.UserService;
import trash.HomeController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class SideBarController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private Text role;
    private static UserService myService = new UserService();
    public static int userid;
    private User u;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

//     User loggedUser = LoginController.getInstance().getLoggedUser();
//        User UserConneter = myService.chercherUtilisateurByid(loggedUser.getId());
//        userid = loggedUser.getId();
//        System.out.println("deeerfr"+userid);
        
        
        
//        UserService s = new UserService();
//       User uc = s.chercherUtilisateurByid(u.getId());
//       
//        System.out.println("hhhhhhhh"+u.getId());
        
        

    }

    @FXML
    private void dashboard(MouseEvent event) {
        loadUI("/Gui/Dashboard");
    }

    @FXML
    private void project(MouseEvent event) {
        loadUI("/Gui/Project");

    }

    @FXML
    private void task(MouseEvent event) {
    }

    @FXML
    private void prodbacklog(MouseEvent event) {
    }

    @FXML
    private void sprints(MouseEvent event) {
    }

    @FXML
    private void document(MouseEvent event) {
        loadUI("/Gui/Document");
    }

    @FXML
    private void team(MouseEvent event) {
    }

    @FXML
    private void meeting(MouseEvent event) {

        loadUI("/Gui/Meeting");

    }

    @FXML
    private void claim(MouseEvent event) {
        loadUI("/Gui/MeetingClaim");

    }

    @FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) borderpane.getScene().getWindow();
        stage.close();
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

}
