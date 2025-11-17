package assignment2_massimo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author massi
 */
public class Assignment2_Massimo extends Application {

    /**
     * @param args the command line arguments
     */
    private int currentIndex = 0;
    private double speed = 1.5; // seconds per image
    private Timeline timeline;
    private boolean isPlaying = false;
    private MediaPlayer backgroundSong;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Loading the fxml scene 
        Parent fxmlRoot = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene fxmlScene = new Scene(fxmlRoot);

        //Scene 2 Slideshow Scene
        BorderPane slideshowPane = new BorderPane();
        Label lblImage = new Label();
        lblImage.setAlignment(Pos.CENTER);
        //Background audio 
        Media media = new Media(getClass().getResource("/assignment2_massimo/images/song.mp3").toExternalForm());
        backgroundSong = new MediaPlayer(media);
        backgroundSong.setCycleCount(MediaPlayer.INDEFINITE);

        //Initializing runner images
        Image[] images = new Image[5];
        for (int i = 0; i < 5; i++) {
            images[i] = new Image(getClass().getResource("/assignment2_massimo/images/marathoner" + (i + 1) + ".jpg").toExternalForm());
        }

        //Display names of runners
        String[] names = {
            "Runner 1",
            "Runner 2",
            "Runner 3",
            "Runner 4",
            "Runner 5"
        };

        //Setting image views 
        ImageView imageView = new ImageView(images[currentIndex]);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);
        lblImage.setGraphic(imageView);

        //Marathoner name label displays
        Label nameLabel = new Label(names[currentIndex]);
        nameLabel.setFont(new Font(28));
        nameLabel.setStyle("-fx-font-weight: bold;");
        nameLabel.setTextFill(Color.WHITE);

        //Runner image display Vbox
        VBox centerBox = new VBox(20, lblImage, nameLabel);
        centerBox.setAlignment(Pos.CENTER);
        slideshowPane.setCenter(centerBox);
        Scene slideshowScene = new Scene(slideshowPane, 800, 600);

        // Timeline runs once, then switches scenes
        timeline = new Timeline(new KeyFrame(Duration.seconds(speed), e -> {
            currentIndex = (currentIndex + 1) % images.length;
            imageView.setImage(images[currentIndex]);
            nameLabel.setText(names[currentIndex]);
        }));
        // Show all 5 images once
        timeline.setCycleCount(5);

        // When slideshow finishes Go to FXML Scene
        timeline.setOnFinished(e -> {
            stage.setScene(fxmlScene);
        });

        // Start screen scene layout
        Pane startPane = new Pane();
        startPane.setPrefSize(800, 600);
        Label startLabel = new Label("Marathon Simulator");
        startLabel.setFont(new Font(32));
        startLabel.setTextFill(Color.WHITE);

        startLabel.layoutXProperty().bind(startPane.widthProperty().subtract(startLabel.widthProperty()).divide(2));
        startLabel.setLayoutY(40);

        Button startButton1 = new Button("Start");
        startButton1.setFont(new Font(22));
        //centering start button
        startButton1.layoutXProperty().bind(startPane.widthProperty().subtract(startButton1.widthProperty()).divide(2));
        startButton1.layoutYProperty().bind(startPane.heightProperty().subtract(startButton1.heightProperty()).divide(2));

        // Background image
        Image bgImage = new Image(getClass().getResource("images\\background.jpg").toExternalForm());
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
        //setting the background image in both scenes
        startPane.setBackground(new Background(backgroundImage));
        slideshowPane.setBackground(new Background(backgroundImage));

        // Start button action
        startButton1.setOnAction(e -> {
            stage.setScene(slideshowScene);// go to Scene 2
            backgroundSong.play();          // play the background song 
            timeline.play();                // begin slideshow
        });

        startPane.getChildren().addAll(startLabel, startButton1);
        Scene startScene = new Scene(startPane);

        // Display start scene
        stage.setScene(startScene);
        stage.show();
    }
}
