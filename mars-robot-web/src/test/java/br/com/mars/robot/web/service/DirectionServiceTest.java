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

        Assert.assertEquals(Direction.WEST, map.get(Commands.LEFT));
        Assert.assertEquals(Direction.EAST, map.get(Commands.RIGHT));
    }

    @Test
    public void validateSidesSouth() {
        Map map = this.directionService.sides.get(Direction.SOUTH);

        Assert.assertEquals(Direction.EAST, map.get(Commands.LEFT));
        Assert.assertEquals(Direction.WEST, map.get(Commands.RIGHT));
    }

    @Test
    public void validateSidesEast() {
        Map map = this.directionService.sides.get(Direction.EAST);

        Assert.assertEquals(Direction.NORTH, map.get(Commands.LEFT));
        Assert.assertEquals(Direction.SOUTH, map.get(Commands.RIGHT));
    }

    @Test
    public void validateSidesWest() {
        Map map = this.directionService.sides.get(Direction.WEST);

        Assert.assertEquals(Direction.SOUTH, map.get(Commands.LEFT));
        Assert.assertEquals(Direction.NORTH, map.get(Commands.RIGHT));
    }
}
