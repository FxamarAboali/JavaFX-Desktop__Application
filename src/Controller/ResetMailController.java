/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import Utils.MailApi;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ResetMailController implements Initializable {
     @FXML
    private TextField userMail;
    @FXML
    private Label error;

    AdminController admin;
    @FXML
    private AnchorPane container;
    @FXML
    private JFXButton loginButton;

    public ResetMailController() throws IOException {
        this.admin = new AdminController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    public boolean mailValidate() {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        validator.setMessage("email not valid");
        Matcher matcher = pattern.matcher(userMail.getText());

        if (matcher.matches()) {
            return true;
        } else {
            error.setText("user mail not valid");
            return false;
        }
    }

    @FXML
    public void resetPassword(ActionEvent actionEvent) {
                            error.setText("check your email ");

        if (mailValidate()) {
            error.setText("");
            try {
                User user = admin.getUserByEmail(userMail.getText());
                if (user != null) {
                    error.setText("");
                    String password = randomAlphaNumeric(20);
                    MailApi.sendMail(userMail.getText(), password);
                    error.setText("check your email ");
                    admin.updateUserPassword(user.getId(), password);
                } else {
                    error.setText("User mail not found");
                }
            } catch (Exception ex) {
                Logger.getLogger(ResetMailController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    @FXML
    public void goToLoginPage(MouseEvent actionEvent) throws IOException {

               Parent root = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

        Scene scene = loginButton.getScene();

        root.translateXProperty().set(scene.getWidth());

        Pane parentContainer = (Pane) scene.getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            parentContainer.getChildren().remove(container);
        });
        timeline.play();


    }
}
