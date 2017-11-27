package br.com.mars.robot.web.entity;


import static br.com.mars.robot.web.utils.Constants.*;

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


}
