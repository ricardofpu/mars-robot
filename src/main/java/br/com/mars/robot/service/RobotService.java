package br.com.mars.robot.service;

import br.com.mars.robot.entity.Direction;
import br.com.mars.robot.entity.Point;
import br.com.mars.robot.utils.MarsZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RobotService {

    private Point point;
    private Direction direction;

    @Autowired
    private MarsZone marsZone;

    @PostConstruct
    private void initPosition() {
        Point point = marsZone.getZone().getPoint(0, 0);
        setInitPosition(point, Direction.NORTH);
    }

    public void handleCommand(String commands) {
        for (char command : commands.toCharArray()) {
            if(isMoveCommand(command)) {

            }
        }
    }

    public String getPosition() {
        return new StringBuilder().append(point.getX()).append(", ")
                .append(point.getY()).append(", ")
                .append(direction.valueOf()).toString();
    }

    private void setInitPosition(Point point, Direction direction) {
        setPoint(point);
        setDirection(direction);
    }

    private void setPoint(Point point) {
        this.point = point;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    private boolean isMoveCommand(char command) {
        return command == 'M';
    }
}
