package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javax.sound.sampled.Line;
import java.lang.Math;

public class MyLine extends MyShape {
    public MyPoint point1,point2;

    public MyLine(MyPoint point1, MyPoint point2){
       this.point1 = point1;
       this.point2 = point2;
    }

    public int getLength(){
        return (int) Math.sqrt(((point2.getX()- point1.getX())*(point2.getX()- point1.getX())) - ((point2.getY()-point1.getY())*(point2.getY()- point1.getY())));
    }

    // The angle (in degrees) of the MyLine object with the x-axis
    public int get_Xangle(){
        int angle = (int) ((Math.atan2((point2.getY() - point1.getY()), (point2.getX() - point1.getX())))/(Math.PI/180));
        return angle;
    }

    @Override
    public String toString() {
        return "MyLine: Length = " + getLength() + " Angle = " + get_Xangle() + " degrees";
    }

    @Override
    public void draw(GraphicsContext graphics) {
        System.out.println(toString());
        graphics.setLineWidth(5);graphics.strokeLine(point1.getX(),point1.getY(),point2.getX(), point2.getY());
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
