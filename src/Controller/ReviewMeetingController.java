/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Meeting;
import Service.MeetingService;
import Utils.ReviewMeetingPDF;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ReviewMeetingController implements Initializable {
     @FXML
    private TableView<Meeting> meetings;
    @FXML
    private TableColumn<Meeting,String> title;
    @FXML
    private TableColumn<Meeting,String> date;
    @FXML
    private TableColumn<Meeting,String>goal;
    @FXML
    private TableColumn<Meeting,String>issues;
    @FXML
    private TableColumn<Meeting,String>project;
    @FXML
    private TableColumn<Meeting,String> type;
    @FXML
    private TableColumn<Meeting,String> duration;
    @FXML
    private TableColumn<Meeting,String> location;
    @FXML
    private TextField filterField;
        private final ObservableList<Meeting> aff = FXCollections.observableArrayList();
    public String sendTitle;
    @FXML
    private TableColumn<Meeting,String>organizedBy;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         MeetingService ser = new MeetingService();
        List<Meeting> lus = ser.selectAllReview();
        aff.addAll(lus);
        meetings.getItems().clear();
        meetings.setItems(aff);
        title.setCellValueFactory(new PropertyValueFactory<Meeting, String>("title"));
        goal.setCellValueFactory(new PropertyValueFactory<Meeting, String>("goal"));
        issues.setCellValueFactory(new PropertyValueFactory<Meeting, String>("issues"));
        project.setCellValueFactory(new PropertyValueFactory<Meeting, String>("project_id"));
        type.setCellValueFactory(new PropertyValueFactory<Meeting, String>("type"));
        date.setCellValueFactory(new PropertyValueFactory<Meeting, String>("date"));
        duration.setCellValueFactory(new PropertyValueFactory<Meeting, String>("duration"));
        location.setCellValueFactory(new PropertyValueFactory<Meeting, String>("location"));
        organizedBy.setCellValueFactory(new PropertyValueFactory<Meeting, String>("organizedBy"));
    }    

    @FXML
    private void FiltredDisplay(ActionEvent event) {
    }

    @FXML
    private void openDailyS(ActionEvent event) throws SQLException {
        
        sendTitle = meetings.getSelectionModel().getSelectedItem().getTitle(); // newWindow("DailyViewFile");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/MeetingDetail.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DailyMeetingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        MeetingDetailController y = loader.getController();
        y.sendText(sendTitle);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }


    @FXML
    private void modifyDailyS(ActionEvent event) throws IOException, SQLException {
           sendTitle = meetings.getSelectionModel().getSelectedItem().getTitle(); 
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/EditMeeting.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ReviewMeetingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        EditMeetingController y = loader.getController();
        y.Data((Meeting) meetings.getSelectionModel().getSelectedItem());

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }


    @FXML
    private void pdfDaily(ActionEvent event) throws SQLException, IOException {
         ReviewMeetingPDF pdf = new ReviewMeetingPDF();

        try {
            pdf.listMeetings();
        } catch (DocumentException ex) {
            Logger.getLogger( ReviewMeetingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void statDaily(ActionEvent event) {
    }

    @FXML
    private void deleteReview(ActionEvent event) {
          MeetingService RService = new MeetingService();
        RService.Delete((Meeting) meetings.getSelectionModel().getSelectedItem());
        meetings.getItems().remove(meetings.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void deleteAllDaily(ActionEvent event) {
               MeetingService sp = new MeetingService();
        sp.DeleteAllReview();
    }
}
