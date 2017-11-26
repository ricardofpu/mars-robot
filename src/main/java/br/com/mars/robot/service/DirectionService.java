package br.com.mars.robot.service;

import br.com.mars.robot.entity.Direction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class DirectionService {

    public Map<Direction, Map> sides = new HashMap<>();

    @PostConstruct
    public void initSides() {
        this.sides.putIfAbsent(Direction.NORTH, setSides(Direction.WEST, Direction.EAST));
        this.sides.putIfAbsent(Direction.SOUTH, setSides(Direction.EAST, Direction.WEST));
        this.sides.putIfAbsent(Direction.EAST, setSides(Direction.NORTH, Direction.SOUTH));
        this.sides.putIfAbsent(Direction.WEST, setSides(Direction.SOUTH, Direction.NORTH));
    }

    private Map setSides(Direction left, Direction right) {
        Map<Character, Direction> map = new HashMap<>();
        map.put('L', left);
        map.put('R', right);
        return map;
    }
}
