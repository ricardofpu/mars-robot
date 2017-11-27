package br.com.mars.robot.web.service;

import br.com.mars.robot.web.entity.Robot;
import br.com.mars.robot.web.exception.InvalidPositionException;
import br.com.mars.robot.web.exception.RobotCommandInvalidException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RobotServiceTest {

    @Autowired
    private RobotService robotService;

    @Test
    public void handleCommandOneMoveSuccess() {
        String command = "M";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "0, 1, N");
    }

    @Test
    public void handleCommandTwoMovesSuccess() {
        String command = "MM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "0, 2, N");
    }

    @Test
    public void handleCommandTwoMovesAndLeftRotateSuccess() {
        String command = "MML";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "0, 2, W");
    }

    @Test
    public void handleCommandTwoMovesAndRightRotateSuccess() {
        String command = "MMR";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "0, 2, E");
    }

    @Test
    public void handleCommandOneRotateRightAndTwoMovesSuccess() {
        String command = "RMM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "2, 0, E");
    }

    @Test
    public void handleCommandOneRotateRightAndTwoMovesAndOneRotateLeftSuccess() {
        String command = "RMML";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "2, 0, N");
    }

    @Test
    public void handleCommandTwoMovesAndOneRotateRightAndTwoMovesSuccess() {
        String command = "MMRMM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "2, 2, E");
    }

    @Test
    public void handleCommandToLastPositionSuccess() {
        String command = "MMMMRMMMM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals(robot.getPosition(), "4, 4, E");
    }

    @Test(expected = RobotCommandInvalidException.class)
    public void failHandleCommandInvalid() {
        String command = "AAA";
        robotService.handleCommands(command);
    }

    @Test(expected = RobotCommandInvalidException.class)
    public void failHandleAnotherCommandInvalid() {
        String command = "ULL";
        robotService.handleCommands(command);
    }

    @Test(expected = InvalidPositionException.class)
    public void failHandleCommandToInvalidPosition() {
        String command = "MMMMMMMM";
        robotService.handleCommands(command);
    }

}
