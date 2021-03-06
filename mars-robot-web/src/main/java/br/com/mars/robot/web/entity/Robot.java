package br.com.mars.robot.web.entity;

import br.com.mars.robot.exception.RobotCommandInvalidException;
import br.com.mars.robot.web.service.DirectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Robot {

    private Logger LOG = LogManager.getLogger(this.getClass());

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

    public void rotate(DirectionService directionService, Commands command) {
        Direction direction = (Direction) directionService.sides.get(this.direction).get(command);
        if (direction == null) {
            LOG.debug("Command {} received are invalid.", command);
            throw new RobotCommandInvalidException();
        }
        this.setDirection(direction);
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
