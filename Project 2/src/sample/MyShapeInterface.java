package sample;
import javafx.scene.paint.Color;
public interface MyShapeInterface{


    Color color = null;

  public  MyRectangle getMyBoundingRectangle();

    public double getMyArea();

    public static boolean overlapMyRectangle(MyRectangle r1, MyRectangle r2) {
        double x1 = r1.getPoint().getX();
        double y1 = r1.getPoint().getY();
        double width1 = r1.getWidth();
        double height1 = r1.getHeight();

        double x2 = r1.getPoint().getX();
        double y2 = r2.getPoint().getY();
        double width2 = r2.getWidth();
        double height2 = r2.getHeight();

        if (y1 + height1 < y2 || y1 > y2 + height2) {
            return false;
        }
        if (x1 + width1 < x2 || x1 > x2 + width2) {
            return false;
        }
        return true;
    }

    public static MyRectangle overlapMyRectangles(MyRectangle r1, MyRectangle r2) {
        double x1 = r1.getPoint().getX();
        double y1 = r1.getPoint().getY();
        double width1 = r1.getWidth();
        double height1 = r1.getHeight();

        double x2 = r1.getPoint().getX();
        double y2 = r2.getPoint().getY();
        double width2 = r2.getWidth();
        double height2 = r2.getHeight();

        if (y1 + height1 < y2 || y1 > y2 + height2) {
            return null;
        }
        if (x1 + width1 < x2 || x1 > x2 + width2) {
            return null;
        }
        double xmax=Math.max(x1,x2);
        double ymax=Math.max(x1,x2);
        double xmin=Math.max(x1+width1,x2+width2);
        double ymin=Math.max(y1+height1,y2+height2);

        MyPoint p= new MyPoint((int)xmax,(int)ymax);
        return new MyRectangle(p, Math.abs(xmin-xmax),Math.abs(ymin-ymax), color);
    }
    public static MyRectangle overlapMyShapes(MyShape s1, MyShape s2){
        if(s1 instanceof MyLine || s2 instanceof MyLine){
            return null;
        }
        MyRectangle r1=s1.getMyBoundingRectangle();
        MyRectangle r2=s2.getMyBoundingRectangle();
        return overlapMyRectangles(r1,r2);
    }



}


