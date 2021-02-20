package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.sound.sampled.Line;

public class MyRectangle extends MyShape {
    double width, height;
    MyPoint point;
    Color color;

    public MyRectangle(MyPoint point, double width, double height, Color color){

        this.point = point;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter(){ return 2 * (getWidth() + getHeight()); }

    public MyPoint getPoint () {
        return point;
    }
    @Override
    public String toString() {
        return " Width = " + getWidth() + " Height = " + getHeight() +
                " Perimeter = " + getPerimeter() + " Area = " + getArea();
    }

    @Override
    public void draw(GraphicsContext graphics) {
        System.out.println(toString());
        graphics.setFill(color);
        graphics.fillRect(point.getX(),point.getY(), getWidth(), getHeight());
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        return null;
    }

    @Override
    public double getMyArea() {
        return 0;
    }

}
