package lab9_massimo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author massi
 */
public class Lab9_Massimo extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent fxmlRoot = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene fxmlScene = new Scene(fxmlRoot);
        stage.setScene(fxmlScene);
        stage.show();
    }
    
}
