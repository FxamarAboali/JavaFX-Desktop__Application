/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.MeetingClaim;
import Service.MeetingClaimService;
import Utils.ClaimPDF;
import Utils.TrayIconDemo;
import com.lowagie.text.DocumentException;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
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
public class ClaimsController implements Initializable {
    @FXML
    private TableView<MeetingClaim> claims;
    @FXML
    private TableColumn<MeetingClaim, String> name;
    @FXML
    private TableColumn<MeetingClaim, String> lastname;
    @FXML
    private TableColumn<MeetingClaim, String> email;
    @FXML
    private TableColumn<MeetingClaim, String> phone;
    @FXML
    private TableColumn<MeetingClaim, String> available;
    @FXML
    private TableColumn<MeetingClaim, String> other;
    @FXML
    private TableColumn<MeetingClaim, String> reason;
    @FXML
    private TableColumn<MeetingClaim, String> date;
    @FXML
    private TextField filterField;
    
    public int sendid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          MeetingClaimService meet = new MeetingClaimService();
        ArrayList arrayList = (ArrayList) meet.selectAll();
        ObservableList observablelist = FXCollections.observableArrayList(arrayList);
        claims.setItems(observablelist);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        phone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        available.setCellValueFactory(new PropertyValueFactory<>("available"));
        other.setCellValueFactory(new PropertyValueFactory<>("other"));
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }    

    @FXML
    private void FiltredDisplay(ActionEvent event) {
    }

    @FXML
    private void open(ActionEvent event) throws SQLException {
 sendid = claims.getSelectionModel().getSelectedItem().getId(); // newWindow("DailyViewFile");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/MeetingClaimDetail.fxml"));

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ClaimsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        MeetingClaimDetailController y = loader.getController();
        y.sendText(sendid);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

    @FXML
    private void modifyClaim(ActionEvent event) throws IOException {
        
           FXMLLoader fxmlloder = new FXMLLoader();
        fxmlloder.setLocation(getClass().getResource("/Gui/EditClaim.fxml"));
        
        Parent root = fxmlloder.load();
        EditClaimController controller = fxmlloder.getController();
        controller.Data((MeetingClaim) claims.getSelectionModel().getSelectedItem());
        Scene home_scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home_scene);
    
        stage.show();
        
    }

    @FXML
    private void deleteClaim(ActionEvent event) {
        
         MeetingClaimService RService = new MeetingClaimService();
        RService.Delete((MeetingClaim) claims.getSelectionModel().getSelectedItem());
        claims.getItems().remove(claims.getSelectionModel().getSelectedItem());
        
               if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.DeleteClaimTray();
                } catch (AWTException ex) {
                    Logger.getLogger(MeetingClaimService.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    }

    @FXML
    private void deleteAllClaims(ActionEvent event) {
          MeetingClaimService RService = new  MeetingClaimService();
        RService.DeleteAll();
        
        if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.DeleteAllClaimTray();
                } catch (AWTException ex) {
                    Logger.getLogger(MeetingClaimService.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
    }

    @FXML
    private void pdfClaim(ActionEvent event) throws SQLException, IOException {
        
         ClaimPDF pdf = new ClaimPDF();

        try {
            pdf.listClaims();
        } catch (DocumentException ex) {
            Logger.getLogger( MeetingClaimController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
