package sample;

import javafx.scene.paint.Color;

public enum MyColor {

    BLACK, WHITE, RED, GREEN, BLUE, PINK, GRAY, YELLOW, PURPLE;

    Color c;

    MyColor() {
        switch (this.ordinal()) {
            case 0:
                this.c = Color.BLACK;
                break;
            case 1:
                this.c = Color.DARKGREEN;
                break;
            case 2:
                this.c = Color.ORANGE;
                break;
            case 3:
                this.c = Color.YELLOW;
                break;
            case 4:
                this.c = Color.RED;
                break;
            case 5:
                this.c = Color.PURPLE;
                break;
            case 6:
                this.c = Color.GREEN;
        }
    }