package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[9][9];
        Scanner sc = new Scanner(System.in);

        System.out.println("How many mines do you want on the field?");
        int numberOfMines = sc.nextInt();

        Minesweeper minesweeper = new Minesweeper(arr, numberOfMines);

        minesweeper.fillField();
        minesweeper.placeMines();
        minesweeper.chekMines();
        minesweeper.printField();
    }
}