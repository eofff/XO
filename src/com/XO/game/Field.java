package com.XO.game;

public class Field {
    private static final int DEFAULT_FIELD_SIZE = 3;

    private static final int MIN_INDEX = 0;

    private static final char DEFAULT_CELL_VALUE = ' ';

    private final int fieldSize;

    private static char[][] field;

    public Field() {
        this(DEFAULT_FIELD_SIZE);

    }

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new char[fieldSize][fieldSize];

    }

    public void init() {
        for (int i = MIN_INDEX; i < fieldSize; i++) {
            lineInit(i);
        }
    }

    private void lineInit(int lineNumber) {
        for (int i = MIN_INDEX; i < fieldSize; i++) {
            field[lineNumber][i] = DEFAULT_CELL_VALUE;
        }
    }

    private void showLine(int lineNumber) {
        for (int j = MIN_INDEX; j < fieldSize; j++) {
            System.out.print("[" + field[lineNumber][j] + "]");
        }
        System.out.println();
    }

    public void showField() {
        System.out.println();
        for (int i = MIN_INDEX; i < fieldSize; i++) {
            showLine(i);
        }
        System.out.println();


    }

    public int getFieldSize() {
        return fieldSize;
    }

    public char[][] getField() {
        return field;
    }

    public void setCell(char cell, int x, int y) {
          field[x][y] = cell;
    }
}
