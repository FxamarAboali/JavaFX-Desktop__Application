/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Project;
import Service.ProjectService;
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
 * @author Lenovo
 */
public class ProjectViewController implements Initializable {

    @FXML
    private Pane paneProject;
    @FXML
    private Text name;
    @FXML
    private Text description;
    @FXML
    private Text date;
    @FXML
    private Text time;
    @FXML
    private Text category;
    @FXML
    private Text version;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) paneProject.getScene().getWindow();
        stage.close();
    }
    



    public void sendText(String reciveTitle) throws SQLException {

        System.out.println(reciveTitle);
        //title.setText(reciveTitle);
        

        ProjectService sd = new ProjectService();
        Project d = sd.readProject(reciveTitle);
        System.out.println(d.toString());

        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter Time_format = DateTimeFormatter.ofPattern("HH-mm-ss");

        name.setText(d.getTitle());
        description.setText(d.getDescription());

        date.setText(d.getDate_creation().toString());
        time.setText(d.getTime_creation().toString());
        category.setText(d.getCategory());
        version.setText(String.valueOf(d.getVersion()));

    }
}
