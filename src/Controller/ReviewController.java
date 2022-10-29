/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class ReviewController implements Initializable {

    @FXML
    private TableView<?> tableview1;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> dcreation;
    @FXML
    private TableColumn<?, ?> tcreation;
    @FXML
    private TableColumn<?, ?> dmodify;
    @FXML
    private TableColumn<?, ?> tmodify;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<?, ?> username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FiltredDisplay(ActionEvent event) {
    }

    @FXML
    private void view(ActionEvent event) {
    }

    @FXML
    private void modify(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void deleteAll(ActionEvent event) {
    }

    @FXML
    private void pdf(ActionEvent event) {
    }

    
}
