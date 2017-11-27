package br.com.mars.robot.web.service;

import br.com.mars.robot.web.entity.Commands;
import br.com.mars.robot.web.entity.Direction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DirectionServiceTest {

    @Autowired
    private DirectionService directionService;

    @Test
    public void validateSidesNorth() {
        Map map = this.directionService.sides.get(Direction.NORTH);

        Assert.assertEquals(map.get(Commands.LEFT), Direction.WEST);
        Assert.assertEquals(map.get(Commands.RIGHT), Direction.EAST);
    }

    @Test
    public void validateSidesSouth() {
        Map map = this.directionService.sides.get(Direction.SOUTH);

        Assert.assertEquals(map.get(Commands.LEFT), Direction.EAST);
        Assert.assertEquals(map.get(Commands.RIGHT), Direction.WEST);
    }

    @Test
    public void validateSidesEast() {
        Map map = this.directionService.sides.get(Direction.EAST);

        Assert.assertEquals(map.get(Commands.LEFT), Direction.NORTH);
        Assert.assertEquals(map.get(Commands.RIGHT), Direction.SOUTH);
    }

    @Test
    public void validateSidesWest() {
        Map map = this.directionService.sides.get(Direction.WEST);

        Assert.assertEquals(map.get(Commands.LEFT), Direction.SOUTH);
        Assert.assertEquals(map.get(Commands.RIGHT), Direction.NORTH);
    }
}
