/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.User;
import Utils.DataBase;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RegisterController   {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private String image = "";

    ObservableList<String> value = FXCollections.observableArrayList("MASTER", "DEVELOPER", "PRODUCT_OWNER");
    private ImageView img;
    @FXML
    private AnchorPane container;
    @FXML
    private TextField userName;
    @FXML
    private TextField userMail;
    @FXML
    private DatePicker userDayOfBirth;
    @FXML
    private PasswordField userPassword;
    @FXML
    private PasswordField userPasswordConfirm;
    @FXML
    private JFXButton createAccountButton;
    @FXML
    private TextField userCin;
    @FXML
    private ComboBox role;

    @FXML
    private Label error;

    @FXML
    private void open_login_form(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));
        /**
         * **
         */

        final WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        System.out.println(webEngine.isJavaScriptEnabled());
        webEngine.setJavaScriptEnabled(true);
        webEngine.load("http://csgodouble.com");
        webEngine.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/601.6.17 (KHTML, like Gecko) Version/9.1.1 Safari/601.6.17");

        /**
         * **
         */
        Scene scene = createAccountButton.getScene();

        root.translateYProperty().set(scene.getHeight());

        Pane parentContainer = (Pane) scene.getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            parentContainer.getChildren().remove(container);
        });
        timeline.play();

    }

    public void initialize() {
        role.setItems(value);
    }

    public RegisterController() throws IOException {
        connection = DataBase.getInstance().getConnection();
        // role.setItems(value);
    }

    public boolean mailValidate() {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        RequiredFieldValidator validator = new RequiredFieldValidator();//yvalidy mail
        validator.setMessage("Input Required");
        validator.setMessage("email not valid");
        Matcher matcher = pattern.matcher(userMail.getText());

        if (matcher.matches()) {//respect mail expression
            error.setText("");

            return true;
        } else {
            error.setText("email not valid");

            userMail.setText("");
            return false;
        }
    }

    public boolean validateForm() {
        mailValidate();
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");

        if (userCin.getText().toString().length() != 8) {
            error.setText("cin not valid length 8 number required ");
            Integer.parseInt(userCin.getText().toString());

        }
        String str = "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";

        return true;
    }

    public void register(ActionEvent event) throws SQLException {
        if (this.validateForm()) {
            preparedStatement = connection.prepareStatement("select * from user where user_mail =  ? or user_cin= ? ");

            preparedStatement.setString(1, userMail.getText());

            preparedStatement.setString(2, userCin.getText());

            if (!preparedStatement.executeQuery().next()) {

                try {
                    String sql = "INSERT INTO `user` ( username,username_canonical,email,email_canonical,enabled,password,"
                            + "roles,name,lastname,user_mail,user_password,user_phone,user_address,user_photo,user_cin,"
                            + "user_day_birth,user_site,nationality,speciality,bio) VALUES (?, ?, ?, ?, ?,?,?, ?, ?, ?, ?,?,?, ?, ?, ?, ?,?,?,?)";
                    User user = new User();
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, userName.getText());
                    preparedStatement.setString(2, userName.getText());
                    preparedStatement.setString(3, userMail.getText());
                    preparedStatement.setString(4, userMail.getText());
                    preparedStatement.setString(5, "1");
                    preparedStatement.setString(6, userPassword.getText());
                    if (role.getValue().equals("MASTER")) {
                        preparedStatement.setString(7, "\"a:1:{i:0;s:11:\"ROLE_MASTER\";}");
                    } else if (role.getValue().equals("DEVELOPER")) {
                        preparedStatement.setString(7, "\"a:1:{i:0;s:14:\"ROLE_DEVELOPER\";}");
                    } else if (role.getValue().equals("PRODUCT_OWNER")) {
                        preparedStatement.setString(7, "\"a:1:{i:0;s:18:\"PRODUCT_OWNER\";}");
                    }
                    preparedStatement.setString(8, userName.getText());
                    preparedStatement.setString(9, "");
                    preparedStatement.setString(10, "");
                    preparedStatement.setString(11,  userPassword.getText());
                    preparedStatement.setString(12, "");
                    preparedStatement.setString(13, "");
                    preparedStatement.setString(14, "");
                    preparedStatement.setString(15,userCin.getText() );
                      Instant instant = Instant.from(userDayOfBirth.getValue().atStartOfDay(ZoneId.systemDefault()));
                    Date date = Date.from(instant);
                    java.sql.Date date_sql = new java.sql.Date(date.getTime());
                    preparedStatement.setDate(16, date_sql);
                    preparedStatement.setString(17, "");
                    preparedStatement.setString(18, "");
                    preparedStatement.setString(19, "");
                    preparedStatement.setString(20, "");

                    

                    int n = preparedStatement.executeUpdate();
                    if (n > 0) {
                        Node node = (Node) event.getSource();
                        Stage dialogStage = (Stage) node.getScene().getWindow();
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Login.fxml")));
                        dialogStage.setScene(scene);
                        dialogStage.show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                this.infoBox("email or cin is  exist", "error");

            }
        }

    }

    private void infoBox(String infoMessage, String titleBar) {

        {
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void choose(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ALL files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        String pathsInfo = "";
        pathsInfo += "getPath(): " + file.getPath() + "\n";
        pathsInfo += "getAbsolutePath(): " + file.getAbsolutePath() + "\n";

        pathsInfo += (new File(file.getPath())).isAbsolute();

        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] res = baos.toByteArray();
            String encodedImage = Base64.getEncoder().encodeToString(baos.toByteArray());
            this.image = encodedImage;
            Path p = Paths.get(file.getPath());

            img.setImage(new Image(file.toURI().toURL().toExternalForm()));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some problem has occurred. Please try again");
        }

    }

    public void goToLoginPage(MouseEvent actionEvent) throws IOException {

        Node node = (Node) actionEvent.getSource();
        Stage dialogStage = (Stage) node.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Login.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();

    }
    
}
