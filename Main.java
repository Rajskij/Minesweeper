package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[9][9];
        Scanner sc = new Scanner(System.in);
        fillField(arr);

        System.out.println("How many mines do you want on the field?");
        int numberOfMines = sc.nextInt();
        placeMines(arr, numberOfMines);

        printField(arr);
    }
    public static void printField (String[][] arr) {
        for (String[] i : arr) {
            for (String j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static String[][] fillField (String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ".";
            }
        }
        return arr;
    }
    public static String[][] placeMines (String[][] arr, int n) {
        Random random = new Random();
        int l = 0;
        while (l < n) {
            int a = random.nextInt(9);
            int b = random.nextInt(9);
            if (arr[a % arr.length][b % arr.length].equals(".")) {
                arr[a % arr.length][b % arr.length] = "X";
                l++;
            }
        }
        return arr;
    }
}
