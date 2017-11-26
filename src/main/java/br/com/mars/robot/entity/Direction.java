package br.com.mars.robot.entity;


import static br.com.mars.robot.entity.Direction.Constants.*;

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

    class Constants {

        public static final char N = 'N';
        public static final char S = 'S';
        public static final char E = 'E';
        public static final char W = 'W';

    }

}
