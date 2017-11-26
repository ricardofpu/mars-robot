package br.com.mars.robot.web.service;

import br.com.mars.robot.web.entity.Direction;
import br.com.mars.robot.web.entity.Point;
import br.com.mars.robot.web.entity.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    @Autowired
    private MarsZone marsZone;

    @Autowired
    private DirectionService directionService;

    public Robot handleCommands(String commands) {
        Robot robot = createRobotWithDefaultPosition();
        for (char command : commands.toCharArray()) {
            if (isMoveCommand(command)) {
                robot.move();
            } else {
                robot.rotate(directionService, command);
            }
        }
        this.marsZone.validatePoint(robot.getPoint());
        return robot;
    }

    private Robot createRobotWithDefaultPosition() {
        Point point = marsZone.getZone().getPoint(0, 0);
        return new Robot(new Point(point.getX(), point.getY()), Direction.NORTH);
    }

    private boolean isMoveCommand(char command) {
        return command == 'M';
    }
}
