package br.com.mars.robot.entity;

public class Zone {

    private int rows;
    private int cols;
    private Point[][] points;

    public Zone(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        init();
    }

    private void init() {
        points = new Point[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                points[x][y] = new Point(x, y);
            }
        }
    }

    public Point getPoint(int x, int y) {
        return points[x][y];
    }
}
