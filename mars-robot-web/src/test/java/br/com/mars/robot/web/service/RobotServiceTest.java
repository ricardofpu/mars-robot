package br.com.mars.robot.web.service;

import br.com.mars.robot.exception.InvalidPositionException;
import br.com.mars.robot.exception.RobotCommandInvalidException;
import br.com.mars.robot.web.entity.Robot;
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
        Assert.assertEquals("0, 1, N", robot.getPosition());
    }

    @Test
    public void handleCommandTwoMovesSuccess() {
        String command = "MM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals("0, 2, N", robot.getPosition());
    }

    @Test
    public void handleCommandTwoMovesAndLeftRotateSuccess() {
        String command = "MML";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals("0, 2, W", robot.getPosition());
    }

    @Test
    public void handleCommandTwoMovesAndRightRotateSuccess() {
        String command = "MMR";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals("0, 2, E", robot.getPosition());
    }

    @Test
    public void handleCommandOneRotateRightAndTwoMovesSuccess() {
        String command = "RMM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals("2, 0, E", robot.getPosition());
    }

    @Test
    public void handleCommandOneRotateRightAndTwoMovesAndOneRotateLeftSuccess() {
        String command = "RMML";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals("2, 0, N", robot.getPosition());
    }

    @Test
    public void handleCommandTwoMovesAndOneRotateRightAndTwoMovesSuccess() {
        String command = "MMRMM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals("2, 2, E", robot.getPosition());
    }

    @Test
    public void handleCommandToLastPositionSuccess() {
        String command = "MMMMRMMMM";
        Robot robot = robotService.handleCommands(command);

        Assert.assertNotNull(robot);
        Assert.assertEquals("4, 4, E", robot.getPosition());
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
