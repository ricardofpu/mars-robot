package br.com.mars.robot.web.entity;

import static br.com.mars.robot.web.utils.Constants.*;

public enum Commands {

    LEFT(L),
    RIGHT(R),
    MOVE(M);

    private final char value;

    private Commands(char value) {
        this.value = value;
    }

    public char valueOf() {
        return this.value;
    }

    public static Commands valueOf(char value) {
        for (Commands command : Commands.values()) {
            if (value == command.valueOf()) {
                return command;
            }
        }
        return null;
    }
}
