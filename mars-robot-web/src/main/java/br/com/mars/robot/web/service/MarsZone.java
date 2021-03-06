package br.com.mars.robot.web.service;

import br.com.mars.robot.exception.InvalidPositionException;
import br.com.mars.robot.web.entity.Point;
import br.com.mars.robot.web.entity.Zone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MarsZone {

    private Logger LOG = LogManager.getLogger(this.getClass());

    @Value("${zone.rows}")
    private int rows;

    @Value("${zone.cols}")
    private int cols;

    private Zone zone;

    @PostConstruct
    public void init() {
        this.zone = new Zone(rows, cols);
    }

    public Zone getZone() {
        return zone;
    }

    public void validatePoint(Point point) {
        try {
            this.zone.getPoint(point.getX(), point.getY());
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.debug("Fail validate point [{}]. Position invalid.", point);
            throw new InvalidPositionException();
        }
    }
}
