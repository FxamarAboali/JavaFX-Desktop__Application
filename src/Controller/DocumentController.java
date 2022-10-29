/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.DailyScrum;
import Service.ServiceGenerateWindow;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.control.Button;
import org.controlsfx.control.PopOver;


/**
 * FXML Controller class
 *
 * @author Deku
 */
public class DocumentController extends ServiceGenerateWindow implements Initializable {

    private final ObservableList<DailyScrum> aff = FXCollections.observableArrayList();
    @FXML
    private BorderPane borderpane;
    @FXML
    private Button newfile;
    private Button b1;

    @FXML
    private Button b2, b3, b4;
    
   

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       super.loadUI("/Gui/DailyScrum", borderpane);

    }

    @FXML
    private void DailyScrumDisplay(ActionEvent event) throws SQLException {

       super.loadUI("/Gui/DailyScrum", borderpane);
   
      
        
    }

    @FXML
    private void PlanningDisplay(ActionEvent event) {
       super.loadUI("/Gui/Planning", borderpane); 
    }

    @FXML
    private void RetrospectiveDisplay(ActionEvent event) {
      super.loadUI("/Gui/Retrospective", borderpane);
    }

    @FXML
    private void ReviewDisplay(ActionEvent event) {
        super.loadUI("/Gui/Review", borderpane);
    }

    @FXML
    private void createNewFile(ActionEvent event) {
        //loadUI("NewFile");

        final String bStyle = "-fx-background-color :linear-gradient(to top left, #35ACF1, #2262C6);"
                + "-fx-text-fill : white ;";
        final String hovred_button = "    -fx-background-color :linear-gradient(to top left,  #F6B46F,#2262C6);"
                + "-fx-text-fill : white ;";

        b1 = new Button("Daily Scrum");
        b2 = new Button("Project Plan");
        b3 = new Button("Sprint Review");
        b4 = new Button("Sprint Retrospective");

        //style par défaut
        b1.setStyle(bStyle);
        b2.setStyle(bStyle);
        b3.setStyle(bStyle);
        b4.setStyle(bStyle);

        b1.setOnMouseEntered(e -> b1.setStyle(hovred_button));
        b2.setOnMouseEntered(e -> b2.setStyle(hovred_button));
        b3.setOnMouseEntered(e -> b3.setStyle(hovred_button));
        b4.setOnMouseEntered(e -> b4.setStyle(hovred_button));

        b1.setOnMouseExited(e -> b1.setStyle(bStyle));
        b2.setOnMouseExited(e -> b2.setStyle(bStyle));
        b3.setOnMouseExited(e -> b3.setStyle(bStyle));
        b4.setOnMouseExited(e -> b4.setStyle(bStyle));

        b1.setMaxSize(120, 170);
        b2.setMaxSize(120, 170);
        b3.setMaxSize(120, 170);
        b4.setMaxSize(120, 170);

        VBox vBox = new VBox(b1, b2, b3, b4);
        vBox.setPrefHeight(120.0);
        vBox.setPrefWidth(120);
        
        PopOver popOver = new PopOver(vBox);
        popOver.show(newfile);
        
        b1.setOnAction((ActionEvent event1) -> {
            super.newWindow("/Gui/DailyFile");
        });
        
        b2.setOnAction((ActionEvent event1) -> {
            super.newWindow("/Gui/PlanningFile");
        });
        
        b3.setOnAction((ActionEvent event1) -> {
            super.newWindow("/Gui/ReviewFile");
        });
        
        b4.setOnAction((ActionEvent event1) -> {
            super.newWindow("/Gui/RetrospectiveFile");
        });

 

    }


    
}
