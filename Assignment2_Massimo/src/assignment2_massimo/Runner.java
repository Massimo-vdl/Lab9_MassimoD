package assignment2_massimo;

import javafx.scene.paint.Color;

/**
 *
 * @author massi
 */
public class Runner {

    private String name;
    private int number;
    private double x;
    private double y;
    private double speed;
    private Color color;

    public Runner() {
        this("Unnamed", 0, 0, 0, 100, Color.BLACK);
    }

    public Runner(String name, int number, double x, double y, double speed, Color color) {
        this.name = name;
        this.number = number;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }
    
    /** Reset runner to starting position. */
    public void reset(double startLine) {
        this.x = startLine;
    }

    /** Check if runner has crossed finish line. */
    public boolean hasFinished(double finishLine) {
        return x >= finishLine;
    }
}
