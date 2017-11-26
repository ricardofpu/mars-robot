package br.com.mars.robot.entity;

import br.com.mars.robot.service.DirectionService;

public class Robot {

    private Point point;
    private Direction direction;

    public Robot() {
    }

    public Robot(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void move() {
        if (this.direction == Direction.NORTH) {
            point.plusY();
        } else if (this.direction == Direction.SOUTH) {
            point.minusY();
        } else if (this.direction == Direction.EAST) {
            point.plusX();
        } else if (this.direction == Direction.WEST) {
            point.minusX();
        }
    }

    public void rotate(DirectionService directionService, char command) {
       Direction direction = (Direction) directionService.sides.get(this.direction).get(command);
       if(direction == null) {
           throw new RuntimeException();
       }
       this.direction = direction;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getPosition() {
        return new StringBuilder().append(this.point.getX()).append(", ")
                .append(this.point.getY()).append(", ")
                .append(this.direction.valueOf()).toString();
    }
}
