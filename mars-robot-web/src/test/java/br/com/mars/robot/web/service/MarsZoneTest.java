package br.com.mars.robot.web.service;

import br.com.mars.robot.exception.InvalidPositionException;
import br.com.mars.robot.web.entity.Point;
import br.com.mars.robot.web.entity.Zone;
import org.junit.Assert;
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

    @Test
    public void getZoneSuccess() {
        Zone zone = marsZone.getZone();
        Assert.assertNotNull(zone);
        Assert.assertNotNull(zone.getPoint(0, 0));
    }

    @Test
    public void getInitialPointSuccess() {
        Point point = marsZone.getZone().getPoint(0, 0);
        Assert.assertEquals(0, point.getX());
        Assert.assertEquals(0, point.getY());
    }

    @Test
    public void getLastPointSuccess() {
        Point point = marsZone.getZone().getPoint(4, 4);
        Assert.assertEquals(4, point.getX());
        Assert.assertEquals(4, point.getY());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void failGetInvalidPoint() {
        marsZone.getZone().getPoint(5, 5);
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
