
package Test;

/**
 *
 * @author Deku
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    /**
     * @param args the command line arguments
     */
 
    private double xOffset,yOffset; 
   

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Gui/Start.fxml"));

        Scene scene = new Scene(root);
        ///copy scene drag and others from a project
        /*stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);*/
        
       scene.setFill(Color.TRANSPARENT );

        //grab your root here
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        //move around here
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    
       public static void main(String[] args) {
         launch(args);
    }
    
}
