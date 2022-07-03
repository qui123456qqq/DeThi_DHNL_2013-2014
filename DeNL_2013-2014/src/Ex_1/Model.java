package Ex_1;

import java.awt.*;

public class Model {
    private int x1,y1,x2,y2;
    private String shape;

    public Model(int x1, int y1, int x2, int y2, String shape) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.shape = shape;
    }
    public Model(Model other) {
        this.shape = other.shape;
        this.x1 = other.x1;
        this.y1 = other.y1;
        this.x2 = other.x2;
        this.y2 = other.y2;
    }
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int actualX() {
        return Math.min(x1, x2);
    }

    public int actualY() {
        return Math.min(y1, y2);
    }

    public int width() {
        return Math.abs(x1 - x2);
    }

    public int height() {
        return Math.abs(y1 - y2);
    }

}
