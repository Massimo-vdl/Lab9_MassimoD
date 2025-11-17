package assignment2_massimo;

import java.util.Random;
import java.util.function.Consumer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author massi
 */
public class Runner {

    double startline = 60;
    double finshLine = 550;
    private String name;
    private int number;
    private double x;
    private double y;
    private double speed;
    private ImageView imageView;
    private Timeline timeline;
    private Consumer<Runner> onFinish;

    private static final Random rand = new Random();

    public Runner() {
        this("Unnamed", 0, 75, 0, randomSpeed(), "/assignment2_massimo/images/running.gif");
    }

    public Runner(String name, int number, double x, double y, String gifPath) {
        this(name, number, x, y, randomSpeed(), gifPath);
    }

    public Runner(String name, int number, double x, double y, double speed, String gifPath) {
        this.name = name;
        this.number = number;
        this.x = x;
        this.y = y;
        this.speed = speed;

        // Load GIF
        Image gif = new Image(getClass().getResource(gifPath).toExternalForm());
        imageView = new ImageView(gif);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
    }

    private static double randomSpeed() {
        // generated random speed
        return 5.0 + rand.nextDouble() * 100.0;
    }

    /**
     * Reset runner to starting position.
     */
    public void reset(double startLine) {
        this.x = startLine;
    }

    /**
     * Check if runner has crossed finish line.
     */
    public boolean hasFinished(double finishLine) {
        return x >= finishLine;
    }

    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Start moving runner along x-axis; stops at finish line
     */
    public void startMoving(Pane pane, double finishLine) {
        if (!pane.getChildren().contains(imageView)) {
            pane.getChildren().add(imageView);
        }

        timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> {
            double nextX = x + speed * 0.02; // speed * deltaTime in seconds
            if (nextX >= finishLine) {
                x = finishLine;
                imageView.setX(x);
                stop();
                if (onFinish != null) {
                    onFinish.accept(this); // notify the controller
                }
            } else {
                x = nextX;
                imageView.setX(x);
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void stop() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    //Getters and Setters
    public void setOnFinish(Consumer<Runner> onFinish) {
        this.onFinish = onFinish;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        if (imageView != null) {
            imageView.setY(y);
        }
    }
    
    public void setNumber(int number){
        this.number = number;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

}
