package com.XO.game;


import com.XO.players.Player;

import java.util.Scanner;

public class XO extends Field {

    private static final int MIN_INDEX = 0;

    private static final char DEFAULT_CELL_VALUE = ' ';

    private Player playerX = new Player();

    private Player playerO = new Player();

    private Player turn = playerO;

    int gameMode;

    Scanner sc = new Scanner(System.in);

    Field fieldObj = new Field();



    public void preGame() {
        System.out.println("1)Играть с компьютером.  2)Игра с локальным противником.  3)Игра с сетевым противником");
        gameMode = sc.nextInt();
        switch (gameMode) {
            case 1:
                System.out.println("Введите ваше имя: ");
                playerX.setName(sc.next());
                playerX.setPlayChar('X');
                playerO.setPlayChar('O');
                playerO.setName(Player.AI_NAME);
                playerO.setIsAi(true);
                break;
            case 2:
                System.out.println("Введите имя первого игрока: ");
                playerX.setName(sc.next());
                playerX.setPlayChar('X');
                System.out.println("Введите имя второго игрока: ");
                playerO.setName(sc.next());
                playerO.setPlayChar('O');
                break;
            case 3:
                //-------------------------------------------------
                break;
            default:
                System.out.println("Введите корректное значение: ");
                preGame();
                break;
            }

        }


    public void setField() {
        boolean isTrue;

        int x = 0,y;
        if (!turn.getIsAi()) {
            if (sc.hasNextInt()) {

                do {
                    x = sc.nextInt() - 1;
                    if (x < MIN_INDEX || x >= fieldObj.getFieldSize()) {
                        isTrue = false;
                        System.out.println("Введите корректное значение х");
                    } else {
                        isTrue = true;
                    }
                }
                while (!isTrue);
            }

            if (sc.hasNextInt()) {

                do {
                    y = sc.nextInt() - 1;
                    if (y < MIN_INDEX || y >= fieldObj.getFieldSize()) {
                        isTrue = false;
                        System.out.println("Введите корректное значение y");
                    } else {
                        isTrue = true;
                    }
                }
                while (!isTrue);

                cellInsert(x, y);
            }
        } else {
            cellInsert();
        }
    }


    public boolean isWin() {
        boolean win = false;

        if ((fieldObj.getField()[0][2] != DEFAULT_CELL_VALUE) && (fieldObj.getField()[2][0] == fieldObj.getField()[0][2]) && fieldObj.getField()[0][2] == fieldObj.getField()[1] [1] && fieldObj.getField()[1][1] != DEFAULT_CELL_VALUE && fieldObj.getField()[2][0] !=DEFAULT_CELL_VALUE) {
            win = true;
        }

        if (fieldObj.getField()[0][0] != DEFAULT_CELL_VALUE && fieldObj.getField()[1][1] != DEFAULT_CELL_VALUE && fieldObj.getField()[2][2] != DEFAULT_CELL_VALUE && (fieldObj.getField()[1] [1] == fieldObj.getField()[2] [2]) && fieldObj.getField()[0][0] == fieldObj.getField()[2] [2]) {
            win = true;
        }

        for (int i = MIN_INDEX; i < fieldObj.getFieldSize(); i++) {
            int j = 0;
            if (fieldObj.getField()[i][j] != DEFAULT_CELL_VALUE && fieldObj.getField()[i][j+1] != DEFAULT_CELL_VALUE && fieldObj.getField()[i][j+2] != DEFAULT_CELL_VALUE && (fieldObj.getField()[i][j] == fieldObj.getField()[i] [j+1] && fieldObj.getField()[i][j+2] == fieldObj.getField()[i][j])) {
                win = true;
            } else if (fieldObj.getField()[j][i] != DEFAULT_CELL_VALUE && fieldObj.getField()[j+1][i] != DEFAULT_CELL_VALUE && fieldObj.getField()[j+2][i] != DEFAULT_CELL_VALUE && (fieldObj.getField()[j] [i] == fieldObj.getField()[j+1][i]) && (fieldObj.getField()[j][i] == fieldObj.getField()[j+2][i])) {
                win = true;
            }
        }

        return win;
    }


    public Player getTurn() {
        return turn;
    }

    public void setTurn(){
        if (turn == playerX) {
            turn = playerO;
        } else if(turn == playerO) {
            turn = playerX;
        }
        System.out.println("Ходит игрок: " + turn.getName());
    }

    private void cellInsert(int x, int y) {
        if (fieldObj.getField()[x][y] == DEFAULT_CELL_VALUE) {
            setCell(turn.getPlayChar(), x, y);
        } else {
            System.out.println("Эта клетка уже занята, выберите другую");
            setField();
        }
    }

    public void cellInsert() {
        int x = (int)(Math.random()*3);
        int y = (int)(Math.random()*3);
        if (fieldObj.getField()[x][y] == DEFAULT_CELL_VALUE) {
            setCell(turn.getPlayChar(), x, y);
        } else {
            cellInsert();
        }
    }
}
