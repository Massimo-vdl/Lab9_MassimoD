package assignment2_massimo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author massi
 */
public class Assignment2_Massimo extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane startPane = new Pane();
        startPane.setPrefSize(800, 600);
        
        Label startLabel = new Label("Marathon Simulator");
        startLabel.setAlignment(Pos.CENTER);
        startLabel.setFont(new Font(32));
        startLabel.setTextFill(Color.WHITE);

        //Initial start button to display the pictures of the runners
        Button startButton1 = new Button("Start");
        startButton1.setFont(new Font(18));
        // Center button horizontally and vertically
        startButton1.layoutXProperty().bind(startPane.widthProperty().subtract(startButton1.widthProperty()).divide(2));
        startButton1.layoutYProperty().bind(startPane.heightProperty().subtract(startButton1.heightProperty()).divide(2));
        
        //background image for the first scene
        Image bgImage = new Image(getClass().getResource("images\\background.jpg").toExternalForm());

        // Create a BackgroundImage object
        BackgroundImage backgroundImage = new BackgroundImage(
                bgImage,
                BackgroundRepeat.NO_REPEAT, // no horizontal repeat
                BackgroundRepeat.NO_REPEAT, // no vertical repeat
                BackgroundPosition.CENTER, // position at center
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true)
        );

        startPane.setBackground(new Background(backgroundImage));
        startPane.getChildren().add(startLabel);
        startPane.getChildren().add(startButton1);

        Scene startScene = new Scene(startPane);
        stage.setScene(startScene);
        stage.show();
    }

}
