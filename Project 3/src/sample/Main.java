package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;


public class Main extends Application {


    public void start(Stage stage){

        // Pass in path name and print frequency
        HistogramAlphaBet alice = new HistogramAlphaBet("Alice in Wonderland.txt");
        alice.createFrequency();

        // Set dimensions
        double x_width = 1200;
        double y_height = 800;

        VBox vbox = new VBox();

        GridPane gp = new GridPane();
        gp.setPadding( new Insets(10) );
        gp.setHgap( 4 );
        gp.setVgap( 10 );

        VBox.setVgrow(gp, Priority.ALWAYS );


        MyPoint tl = new MyPoint(0, 0);
        MyPoint bl = new MyPoint(0, h);
        MyPoint br = new MyPoint(w, h);
        MyPoint tr = new MyPoint(w, 0);

        Canvas canvas = new Canvas(x_width/2,y_height/2);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // Create pie chart
        MyPieChart myPieChart = new MyPieChart(alice.hashMap, alice.total, 3);
        myPieChart.drawPieChart(x_width/2, y_height/2, gc);

        gp.add(canvas, 0, 2);

        vbox.getChildren().addAll( gp);
        Scene scene = new Scene(vbox);

        stage.setTitle("Grid Pane App");
        stage.setScene(scene);
       // stage.setWidth( 414 );
       // stage.setHeight( 736  );
        stage.setWidth(x_width);
        stage.setHeight(y_height);
        stage.show();

    }


    // Main Method
    public static void main(String args[]){
        launch(args);
    }


}
