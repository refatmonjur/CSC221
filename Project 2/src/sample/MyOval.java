package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MyOval extends MyShape{
    MyPoint point;
    double width, height, x, y;
    Color color;

    public MyOval(MyPoint point, double width, double height, Color color) {
        this.point = point;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea(){
        return (Math.PI * width/2 * height/2);
    }

    public double getPerimeter(){
        return 2 * Math.PI * Math.sqrt( (Math.pow(height,2) + Math.pow(width,2)) / 2 );
    }

    @Override
    public String toString() {
        return "MyOval:  Perimeter = " + getPerimeter() + " Area = " + getArea();
    }

    public void draw(GraphicsContext graphics) {
        System.out.println(toString());
        graphics.setFill(color);
        graphics.fillOval(point.getX(), point.getY(), width, height);
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
