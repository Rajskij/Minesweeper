package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] playField = new String[9][9];
        Scanner sc = new Scanner(System.in);

        System.out.println("How many mines do you want on the field?");
        int numberOfMines = sc.nextInt();

        Minesweeper minesweeper = new Minesweeper(playField, numberOfMines);
        minesweeper.fillField();
        minesweeper.placeMines();
        minesweeper.placeNumMarks();

        String[][] userField = new String[9][9];
        UserInput input = new UserInput(userField);
        input.fillUserField(playField);

        while (!input.endGameCheck(playField)) {
            input.printField();
            System.out.println("Set/delete mines marks (x and y coordinates):");
            int x = sc.nextInt();
            int y = sc.nextInt();

            while (playField[y - 1][x - 1].matches("[0-9]")) {
                System.out.println("There is a number here!");
                System.out.println("Set/delete mines marks (x and y coordinates):");
                x = sc.nextInt();
                y = sc.nextInt();
            }
            input.setMark(y-1,x-1);
        }
        input.printField();
        System.out.println("Congratulations! You found all mines!");
    }
}