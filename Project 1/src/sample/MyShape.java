package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyShape {
    protected double x;
    protected double y;
    protected MyColor col;

    public MyShape() {
        x = 0;
        y = 0;

    }

    public MyShape(double xStart, double yStart) {
        x = xStart;
        y = yStart;
    }
    public double getX() {
        return x;
    }

    public void setX(double x)
    {
        x = x; // sets the value of x to the variable x

    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        y = y;
    }

    public MyColor getcol() {
        return col;
    }

    public void setcol(MyColor col) {
        col = col;
    }

    public String toString() {
        return "My Shape object";
    }

    public void draw(GraphicsContext gc, Canvas c) { gc.fillRect(  0,  0, c.getWidth(), c.getHeight());
    }
}
