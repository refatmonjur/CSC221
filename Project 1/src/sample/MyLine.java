package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {
    int numSides;
    double length;

    public MyPolygon() {
        super(0,0);
        numSides = 0;
        length = 0;
    }
    public MyPolygon(double xStart, double yStart, int sides, double len) {
        super(xStart, yStart);
        numSides = sides;
        length = len;
    }
    public double getPerimeter() {
        return length * numSides;

    }
    public double getArea() {
        return (numSides * length * length) / (4.0 * Math.tan(Math.PI / numSides));
    }

    public double getSide() {
        return length;
    }

    public int getAngle() {
        return ((numSides - 2) * 180) / numSides;
    }

    public String toString() {
        return "My Polygon object\n" + "Length of side = " + Double.toString(getSide()) +
                "\nPerimeter of Polygon = " + Double.toString(getPerimeter()) + "\nArea of Polygon = " + Double.toString(getArea()) + "\nInterior angle of Polygon = " + Double.toString(getAngle());
    }

    public void draw(GraphicsContext gc) {
        double[] xPoints = new double[numSides];
        double[] yPoints = new double[numSides];

        for (int i = 0; i < numSides; i++) {
            xPoints[i] = (Math.sin((double) i / numSides * 2 * Math.PI) * length) + x;
            yPoints[i] = (Math.cos((double) i / numSides * 2 * Math.PI) * length) + y;
        }
        //center of polygon and side length will help find the number of points for both x and y //
        gc.fillPolygon(xPoints, yPoints, numSides);
    }
}
