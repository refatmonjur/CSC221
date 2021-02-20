package sample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("MyShapes");
        int w = 900, h = 600;
        Canvas c = new Canvas(w, h);
        GraphicsContext gc = c.getGraphicsContext2D();
        root.getChildren().add(c);
        Scene s = new Scene(root, w, h);
        primaryStage.setScene(s);

        MyPoint tl = new MyPoint(0, 0);
        MyPoint bl = new MyPoint(0, h);
        MyPoint br = new MyPoint(w, h);
        MyPoint tr = new MyPoint(w, 0);

        MyPoint r1 = new MyPoint(w/4, h/4);
        MyPoint r2 = new MyPoint(w/3.12, h/3.12);
        MyPoint r3 = new MyPoint(w/2.7, h/2.7);

        // regular class you create an instance of it
// use for new to declare new instance

        //Outside Shapes
        System.out.println("Rectangle 1:");
        MyRectangle box1 = new MyRectangle(r1, w/2, h/2, MyColor.BLUE.getColor());
        box1.draw(gc);
        MyOval firstoval = new MyOval(r1,w/2,h/2, MyColor.RED.getColor());
        firstoval.draw(gc);

        //Middle Shapes
        System.out.println("Rectangle 2:");
        MyRectangle box2 = new MyRectangle(r2, w/2.8, h/2.8, MyColor.GREEN.getColor());
        box2.draw(gc);
        MyOval secondoval = new MyOval(r2,w/2.8,h/2.8, MyColor.PURPLE.getColor());
        secondoval.draw(gc);

        //Inner Shapes
        System.out.println("Rectangle 3:");
        MyRectangle box3 = new MyRectangle(r3, w/3.95, h/3.95, MyColor.YELLOW.getColor());
        box3.draw(gc);
        MyOval thirdoval = new MyOval(r3,w/3.95,h/3.95, MyColor.PINK.getColor());
        thirdoval.draw(gc);

        //diagonal and border lines
        MyLine diagonal = new MyLine(tl, br);
        diagonal.draw(gc);
        MyLine topside = new MyLine(tl, tr);
        topside.draw(gc);
        MyLine rightside = new MyLine(tr, br);
        rightside.draw(gc);
        MyLine bottomside = new MyLine(br, bl);
        bottomside.draw(gc);
        MyLine leftside = new MyLine(tl, bl);
        leftside.draw(gc);

        primaryStage.show();
    }

        public static void main (String[]args){
            launch(args);
        }

    }