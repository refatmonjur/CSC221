package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyShape {
    private static final double xStart = 0;
    private static final double yStart = 0;
    private double r;

    public MyCircle() {
        super( xStart, yStart);
        r = 0;
    }
    public MyCircle(double x, double y, double rad) {
        super( x - rad,  y - rad);
        r = rad;
    }

    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }
    public double getRadius() {
        return r;
    }

    public String toString() {
        return "My circle object\n" + "Length of radius = " + Double.toString(getRadius()) + "\nPerimeter of Circle = " + Double.toString(getPerimeter()) + "\nArea of Circle = " + Double.toString(getArea());
    }

    public void draw(GraphicsContext gc) {
        double v2, v3;
        gc.fillOval(x, y, r * 2,  r * 2);
    }
}
