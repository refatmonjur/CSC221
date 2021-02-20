package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;


public class MyPieChart {
    MyPoint point;
    MyArc arc;
    double other, total;

    float entries;
    
    // Initiate array lists to be used when plotting on graph
    ArrayList<Color> colors = new ArrayList<>();
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<Double> probabilites = new ArrayList<>();

    public MyPieChart(HashMap<Character, Integer> hashMap, int total, int n) {
        this.point = point;
        this.total = total;

        // Using Java 8 streams to sort top n entries in reverse order
        List<Map.Entry<Character, Integer>> top = hashMap.entrySet().stream()
                .sorted(comparing(Map.Entry::getValue, reverseOrder()))
                .limit(n)
                .collect(toList());

        // Add probabilities and labels for graph
        for(int i=0; i<top.size(); i++){
            probabilites.add(getProbability((top.get(i).getValue())));
            labels.add(top.get(i).getKey().toString() + ": " + probabilites.get(i));
        }

        // Find the sum of top 3
        int sum = 0;
        for(int i=0; i<top.size(); i++){
            sum += top.get(i).getValue();
        }

        // Always add 'Other' into last index of array
        other = total - sum;
        probabilites.add(getProbability(other));
        labels.add("Other" + ": " + probabilites.get(probabilites.size()-1));

    }



    public double getProbability(double n) {
        return Double.parseDouble(String.format("%f", n / total));
    }

    // Create legend with equal spaces with color and label
    public void drawLegend( double x, double y, GraphicsContext gc){
        gc.strokeText("LEGEND", x, y);
        for(int i=0; i<colors.size(); i++) {
            gc.setStroke(Color.BLACK);
            gc.strokeText( labels.get(i), x + 30, y + 30);
            gc.setFill(colors.get(i));
            gc.fillRect(x, y + 15, 20, 20);
            y+=30;
        }
    }

    public void drawPieChart(double totalWidth, double totalHeight, GraphicsContext graphicsContext) {

        // Position away from center and spaced next to legend
        double x = totalWidth / 2D - 100;
        double y = totalHeight / 2D - 200 ;
        // Starting and ending for each arc
        double start = 0;
        double end;

        // Choosing predetermined colors

        colors.add(Color.ORANGE);
        colors.add(Color.LIMEGREEN);
        colors.add(Color.MEDIUMVIOLETRED);
        colors.add(Color.STEELBLUE);

        drawLegend( 50, 100, graphicsContext);

        // Color entire circle, n values will overlap to adjust 'Other' arc
        graphicsContext.setFill(colors.get(3));
        graphicsContext.fillArc(x, y,300 ,300,0,360,ArcType.ROUND);

        // Start where the previous arc ends, and end at an angle calculated by probability
        end = (probabilites.get(0))*360.00;
        for(int i=0; i<probabilites.size()-1; i++) {
            graphicsContext.setFill(colors.get(i));
            graphicsContext.fillArc(x, y,300 ,300,start,end,ArcType.ROUND);
            start = start+end; // Get location for previous arc ended
            end = (probabilites.get(i+1))*360.00; // end at the next angle from probability
        }

    }
}
