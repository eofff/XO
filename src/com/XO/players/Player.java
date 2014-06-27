package com.XO.players;

/**
 * Created by eof on 25.06.14.
 */
public class Player {

    public static final String AI_NAME = "Computer";

    private String name;

    private boolean isAi = false;

    private char playChar;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlayChar(char playChar) {
        this.playChar = playChar;
    }

    public char getPlayChar() {
        return playChar;
    }

    public void setIsAi(boolean isAi) {
        this.isAi = isAi;
    }

    public boolean getIsAi() {
        return isAi;
    }
}
