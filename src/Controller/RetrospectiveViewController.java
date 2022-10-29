/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Entite.SprintRetrospective;
import Service.ServiceDailyScrum;
import Service.ServiceSprintRetro;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class RetrospectiveViewController implements Initializable {

    @FXML
    private Pane panedaily;
    @FXML
    private Text title;
    @FXML
    private Text Dcreation;
    @FXML
    private Text Tcreation;
    @FXML
    private Text Dmodify;
    @FXML
    private Text Tmodify;
    @FXML
    private Text pname;
    @FXML
    private Text thingst;
    @FXML
    private Text quick;
    @FXML
    private Text what;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exit(ActionEvent event) {
         Stage stage = (Stage) panedaily.getScene().getWindow();
        stage.close();
    }
    
     public void sendText(String reciveTitle) throws SQLException {

        System.out.println(reciveTitle);
        //title.setText(reciveTitle);
        
         ServiceSprintRetro sd = new ServiceSprintRetro();
         SprintRetrospective d = sd.readRetro(reciveTitle);
        System.out.println(d.toString());
            
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter Time_format = DateTimeFormatter.ofPattern("HH-mm-ss");

        title.setText(d.getTitle());
        pname.setText(d.getStartdoing());
        thingst.setText(d.getContinuedoing());
        quick.setText(d.getStopdoing());
        
       
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        Dcreation.setText(df.format(d.getDate_creation()));
        Tcreation.setText((d.getTime_creation().toString()));
        Dmodify.setText(df.format(d.getDate_modification()));
        Tmodify.setText((d.getTime_modification().toString()));

    }
    
}
