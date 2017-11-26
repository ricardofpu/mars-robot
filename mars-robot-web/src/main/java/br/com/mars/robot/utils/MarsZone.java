package br.com.mars.robot.utils;

import br.com.mars.robot.entity.Point;
import br.com.mars.robot.entity.Zone;
import br.com.mars.robot.exception.InvalidPositionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MarsZone {

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
            throw new InvalidPositionException();
        }
    }
}
