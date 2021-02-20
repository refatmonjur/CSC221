package sample;

import javafx.scene.paint.Color;

public enum MyColor {

    //list colors which you're going to use
    BLACK, DARKGREEN, RED, GREEN, BLUE, PINK, GRAY, YELLOW, PURPLE;

    // calls color object, declaring a variable
    Color c;

    // constructor
    MyColor() {
        switch (this.ordinal()) {
            case 0:
                this.c = Color.BLACK;
                break;
            case 1:
                this.c = Color.DARKGREEN;
                break;
            case 2:
                this.c = Color.RED;
                break;
            case 3:
                this.c = Color.GREEN;
                break;
            case 4:
                this.c = Color.BLUE;
                break;
            case 5:
                this.c = Color.PINK;
                break;
            case 6:
                this.c = Color.GRAY;
                break;
            case 7:
                this.c = Color.YELLOW;
                break;
            case 8:
                this.c = Color.PURPLE;
                break;
            default:
                this.c = null;
        }
    }

    public Color getColor() {

        return c;
    }
}
