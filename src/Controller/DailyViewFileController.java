/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Service.ServiceDailyScrum;
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
public class DailyViewFileController implements Initializable {

    @FXML
    private Pane panedaily;
    @FXML
    private Text title;
    @FXML
    private Text workyesterday;
    @FXML
    private Text plantoday;
    @FXML
    private Text workblock;
    @FXML
    private Text brunthrs;
    @FXML
    private Text complethrs;
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void exit(ActionEvent event) {

        Stage stage = (Stage) panedaily.getScene().getWindow();
        stage.close();
    }

    public void sendText(String reciveTitle) throws SQLException {

        System.out.println(reciveTitle);
        //title.setText(reciveTitle);
        
        ServiceDailyScrum sd = new ServiceDailyScrum();
        DailyScrum d = sd.readDaily(reciveTitle);
        System.out.println(d.toString());
            
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter Time_format = DateTimeFormatter.ofPattern("HH-mm-ss");

        title.setText(d.getTitle());
        workyesterday.setText(d.getYesterdaywork());
        plantoday.setText(d.getTodayplan());
        workblock.setText(d.getBlockers());
        brunthrs.setText(String.valueOf(d.getHrsbrunt()));
        complethrs.setText(String.valueOf(d.getHrscompleted()));
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        Dcreation.setText(df.format(d.getDate_creation()));
        Tcreation.setText((d.getTime_creation().toString()));
        Dmodify.setText(df.format(d.getDate_modification()));
        Tmodify.setText((d.getTime_modification().toString()));

    }


}
