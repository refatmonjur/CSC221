package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("MyShapes");
        int w = 800, h = 600;
        Canvas c = new Canvas(w,h);
        GraphicsContext gc = c.getGraphicsContext2D();

        double poly1len = w * 0.25;
        int sides;
        MyPolygon poly1 = new MyPolygon( w/2, h/2,  6, poly1len);
        gc.setFill(MyColor.GRAY.getColor());
        poly1.draw(gc);
        System.out.println(poly1.toString());

        double circle1Rad = Math.sqrt(Math.pow(poly1len,2) - Math.pow(poly1len/2,2));
        double x, y;
        MyCircle circ1 = new MyCircle(  w/2,  h/2, circle1Rad);
        gc.setFill(MyColor.YELLOW.getColor());
        circ1.draw(gc);
        System.out.println(circ1.toString());

        double poly2Len = circle1Rad;
        MyPolygon poly2 = new MyPolygon( w/2, h/2, 6,poly2Len);
        gc.setFill(MyColor.GREEN.getColor());
        poly2.draw(gc);
        System.out.println(poly2.toString());

        double circle2Rad = Math.sqrt(Math.pow(poly2Len,2) - Math.pow(poly2Len/2,2));
        MyCircle circ2 = new MyCircle(  w/2,  h/2, circle2Rad);
        gc.setFill(MyColor.PINK.getColor());
        circ2.draw(gc);
        System.out.println(circ2.toString());

        double poly3Len = circle2Rad;
        MyPolygon poly3 = new MyPolygon( w/2, h/2, 6,poly3Len);
        gc.setFill(MyColor.BLUE.getColor());
        poly3.draw(gc);
        System.out.println(poly3.toString());

        MyLine tB = new MyLine(  50,  50,  w - 50, 50);
        MyLine rB = new MyLine(  w - 50,  50, w - 50, h - 50);
        MyLine bB = new MyLine(  w - 50,  h - 50, 50, h - 50);
        MyLine lB = new MyLine(  50,  h - 50, 50, 50);
        MyLine dLeft = new MyLine(  50,  50, w - 50, h - 50);
        MyLine dRight = new MyLine(  w - 50,  50, 50, h - 50);

        tB.draw(gc);
        rB.draw(gc);
        bB.draw(gc);
        lB.draw(gc);
        dLeft.draw(gc);
        dRight.draw(gc);

        root.getChildren().add(c);
        Scene s = new Scene(root, w, h);
        primaryStage.setScene(s);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
