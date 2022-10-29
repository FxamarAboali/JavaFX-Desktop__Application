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
public class PlanningViewController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Text title;
    @FXML
    private Text analyse;
    @FXML
    private Text evaluate;
    @FXML
    private Text product;
    @FXML
    private Text sprint;
    @FXML
    private Text task;
    @FXML
    private Text Dcreation;
    @FXML
    private Text Tcreation;
    @FXML
    private Text Dmodify;
    @FXML
    private Text Tmodify;

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
    
    public void sendText(String reciveTitle) throws SQLException {

        System.out.println(reciveTitle);
        //title.setText(reciveTitle);
        
        ServicePlanning sd = new ServicePlanning();
        Planning d = sd.readDaily(reciveTitle);
        System.out.println(d.toString());
            
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter Time_format = DateTimeFormatter.ofPattern("HH-mm-ss");

        title.setText(d.getTitle());
        analyse.setText(d.getAnalyse());
        evaluate.setText(d.getEvaluate());
        product.setText(d.getProduct());
        sprint.setText(d.getSprintgoal());
        task.setText(d.getTasks());
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        Dcreation.setText(df.format(d.getDate_creation()));
        Tcreation.setText((d.getTime_creation().toString()));
        Dmodify.setText(df.format(d.getDate_modification()));
        Tmodify.setText((d.getTime_modification().toString()));
        
        

    }

    @FXML
    private void save(ActionEvent event) {
    }
    
}
