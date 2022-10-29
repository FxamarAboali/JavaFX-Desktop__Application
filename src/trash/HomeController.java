/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;


import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class HomeController implements Initializable {

    

    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXHamburger hamburger;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SideBarf.fxml"));
            VBox box = loader.load();
            SideBarfController controller = loader.getController();
            //controller.setCallback(this);
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(1);
        hamburger.addEventHandler(MouseEvent.MOUSE_MOVED, (e) -> {
            transition.setRate(-1);
            transition.play();

            if (drawer.isHover()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });
    }    


   
    
    
}
