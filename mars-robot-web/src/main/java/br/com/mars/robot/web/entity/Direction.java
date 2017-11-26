package br.com.mars.robot.web.entity;


import br.com.mars.robot.web.utils.Constants;

public enum Direction {

    NORTH(Constants.N),
    SOUTH(Constants.S),
    EAST(Constants.E),
    WEST(Constants.W);

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
