package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape implements MyShapeInterface {

    MyPoint point;
    String description;
    Color color;

 public MyPoint getP() {
     return point;
 }

    public void setP(MyPoint p) { this.point = point; }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public String toString() {
        return description;
    }

    public abstract void draw(GraphicsContext graphics);

}
