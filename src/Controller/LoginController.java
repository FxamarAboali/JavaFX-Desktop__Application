/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.User;
import Utils.DataBase;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class LoginController {
  private User loggedUser;
       private static LoginController instance;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private TextField userMail;
    @FXML
    private PasswordField userPassword;
    @FXML
    private AnchorPane container;
    @FXML
    private JFXButton loginButton;
    @FXML
    private Label error;

    @FXML
    private void open_registration_form(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Register.fxml"));

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

    public LoginController() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }
    
     public static LoginController getInstance() {
        return instance;
    }
      public User getLoggedUser() {
        return loggedUser;
    }

    public boolean mailandpasswordValidate() {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(userMail.getText());
        if (userPassword.getText().length() < 8) {
            error.setText("*password length < 8 ");

        }

        if (matcher.matches()) {
            error.setText("");

            return true;
        } else {
            error.setText("*mail not valid");
            return false;
        }
    }

    public void loginAction(ActionEvent actionEvent) {
        String email = userMail.getText();
        String password = userPassword.getText();
        mailandpasswordValidate();
        if (mailandpasswordValidate()) {
            String sql = "SELECT * FROM user WHERE email = ? and user_password = ?;";

            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    error.setText("failed please verifiy your email or password");
                } else {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    error.setText("");

                    Node node;
                    node = (Node) actionEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    if (resultSet.getString("roles").equals("admin")) {
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/SideBar.fxml")));
                        stage.setScene(scene);
                        stage.show();

                    } else{
                            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/SideBar.fxml")));
                        stage.setScene(scene);
                        stage.show();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void changeScenex(ActionEvent actionEvent) throws IOException {

        Node node = (Node) actionEvent.getSource();
        Stage dialogStage = (Stage) node.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/REGISTER.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();

    }

    public void resetPage(MouseEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GUI/resetMail.fxml"));

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

    private void infoBox(String infoMessage, String titleBar) {

        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}
