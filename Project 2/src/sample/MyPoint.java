package sample;

import java.awt.*;

public class MyPoint {

    //We need to create variables for the x and y coordinated of the point
    double x, y;

    //constructor
    MyPoint() {
        this(0, 0);
    }

    MyPoint(double x, double y) {
        boot(x, y);
    }
    MyPoint(MyPoint point) {
        boot(point);
    }

    public void boot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void boot(MyPoint point) {

        this.x = point.getX();
        this.y = point.getY();
    }

    //get method
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}