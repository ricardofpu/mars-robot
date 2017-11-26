package br.com.mars.robot.web.entity;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void plusX() {
        this.x += 1;
    }

    public void minusX() {
        this.x -= 1;
    }

    public void plusY() {
        this.y += 1;
    }

    public void minusY() {
        this.y -= 1;
    }

    public String getCoordinate() {
        return x + ", " + y;
    }

}
