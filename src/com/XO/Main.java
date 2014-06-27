package com.XO;

import com.XO.game.XO;

public class Main {


    public static void main(String[] args) {
        XO field = new XO();
        field.init();
        field.preGame();
       boolean win = false;
        for (int i = 0; i < field.getFieldSize()*field.getFieldSize();i++) {
            field.setTurn();
            field.setField();
            field.showField();
            win = field.isWin();
            if (win) {
                System.out.println("Победил: " + field.getTurn().getName());
                break;
            }

        }
        if (!win) {
            System.out.println("Ничья!");
        }
    }



    }

