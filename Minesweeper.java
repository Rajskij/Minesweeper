package minesweeper;

import java.util.Random;

public class Minesweeper {
    String[][] arr;
    int n;

    public Minesweeper(String[][] arr, int n) {
        this.arr = arr;
        this.n = n;
    }

    public String[][] fillField () {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ".";
            }
        }
        return arr;
    }
    public String[][] placeMines () {
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
    public String[][] placeNumMarks() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!arr[i][j].equals("X")) {
                    int count = getNumMines(i,j);
                    arr[i][j] = count > 0 ? count + "" : ".";
                }
            }
        }
        return arr;
    }
    public int getNumMines (int x, int y) {
        int num = 0;
        for (int i = x - 1; i < x + 2; i++) {
            if (i >= 0 && i < arr.length) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (j >= 0 && j < arr.length && arr[i][j].equals("X")) {
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
