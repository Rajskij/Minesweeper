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

        UserInput input = new UserInput();
        String[][] userField = input.fillUserField(playField);
        String[][] openNumbers = new String[9][9];
        fillEmptyArr(openNumbers);
        boolean mine = false;

        while (!mine && !input.endGameCheck(playField, userField) && !input.openNumbersCheck(playField, openNumbers)) {
            openNumbers = input.printField(userField, openNumbers);
            System.out.println("Set/unset mine marks or claim a cell as free:");
            int x = sc.nextInt();
            int y = sc.nextInt();
            String str = sc.next();

            switch (str) {
                case "free":
                    if (userField[y - 1][x - 1].matches("[0-9]")) {
                        openNumbers[y - 1][x - 1] = userField[y - 1][x - 1];
                    }
                    input.userInput(userField, y - 1, x - 1);
                    mine = userField[y - 1][x - 1].equals("X");
                    break;
                case "mine":
                    openNumbers[y - 1][x - 1] = openNumbers[y - 1][x - 1].equals("*")
                            ? "." : "*";
                    userField[y-1][x-1] = userField[y-1][x-1].equals("X") ? "*"
                            : userField[y-1][x-1].equals(".") ? "*"
                            : userField[y-1][x-1].matches("[0-9]") ? "*"
                            : userField[y-1][x-1].equals("*") & playField[y-1][x-1].matches("[0-9]") ? playField[y-1][x-1]
                            : userField[y-1][x-1].equals("*") & playField[y-1][x-1].equals("X") ? "X" : ".";
                    break;
                default:
                    break;
            }


        }
        input.printFieldAll(playField);
        System.out.println(mine ? "You stepped on a mine and failed!"
                : "Congratulations! You found all mines!");
    }
    public static void fillEmptyArr (String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ".";
            }
        }
    }
}