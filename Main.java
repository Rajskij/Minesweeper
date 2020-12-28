package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] playField = new String[9][9];
        String[][] userField = new String[9][9];
        Scanner sc = new Scanner(System.in);

        System.out.println("How many mines do you want on the field?");
        int numberOfMines = sc.nextInt();

        Minesweeper minesweeper = new Minesweeper(playField, numberOfMines);

        minesweeper.fillField();
        minesweeper.placeMines();
        minesweeper.chekMines();

        UserInput input = new UserInput(playField);
        input.fillUserField();

        while (input.endGameCheck(playField)) {
            input.printField();
            System.out.println("Set/delete mines marks (x and y coordinates):");
            int x = sc.nextInt();
            int y = sc.nextInt();
            while (playField[x][y].matches("[\\d]")) {
                System.out.println("There is a number here!");
                System.out.println("Set/delete mines marks (x and y coordinates):");
                x = sc.nextInt();
            }
            input.setMark(x - 1, y - 1);
        }
    }
}