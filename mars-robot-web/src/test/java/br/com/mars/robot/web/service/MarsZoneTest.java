package br.com.mars.robot.web.service;

import br.com.mars.robot.web.entity.Point;
import br.com.mars.robot.web.entity.Zone;
import br.com.mars.robot.web.exception.InvalidPositionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarsZoneTest {

    @Autowired
    private MarsZone marsZone;

    private Zone zone;

    @Before
    public void init() {
        this.zone = marsZone.getZone();
        Assert.assertNotNull(zone);
    }

    @Test
    public void getInitialPointSuccess() {
        Point point = marsZone.getZone().getPoint(0, 0);
        Assert.assertEquals(point.getX(), 0);
        Assert.assertEquals(point.getY(), 0);
    }

    @Test
    public void getLastPointSuccess() {
        Point point = marsZone.getZone().getPoint(4, 4);
        Assert.assertEquals(point.getX(), 4);
        Assert.assertEquals(point.getY(), 4);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void failGetInvalidPoint() {
        Point point = marsZone.getZone().getPoint(5, 5);
    }

    @Test
    public void validatePointSuccess() {
        Point point = marsZone.getZone().getPoint(4, 4);
        Assert.assertNotNull(point);

        marsZone.validatePoint(point);
    }

    @Test(expected = InvalidPositionException.class)
    public void failValidateWhenPointIsInvalid() {
        Point point = new Point(5, 5);
        Assert.assertNotNull(point);

        marsZone.validatePoint(point);
    }

}
