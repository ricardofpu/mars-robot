package br.com.mars.robot.entity;


import static br.com.mars.robot.utils.Constants.*;

public enum Direction {

    NORTH(N),
    SOUTH(S),
    EAST(E),
    WEST(W);

    private final char value;

    private Direction(char value) {
        this.value = value;
    }

    public char valueOf() {
        return this.value;
    }

    private Direction valueOf(char dir) {
        for (Direction direction : Direction.values()) {
            if (dir == direction.valueOf()) {
                return direction;
            }
        }
        return null;
    }

}
