package minesweeper;

public class UserInput {

    public boolean openNumbersCheck(String[][] playField, String[][] openNum) {
        boolean endGame = true;
        for (int i = 0; i < openNum.length; i++) {
            for (int j = 0; j < openNum.length; j++) {
                 if (openNum[i][j].equals(".") && playField[i][j].matches("[0-9]")) {
                    endGame = false;
                    break;
                }
            }
        }
        return endGame;
    }

    public boolean endGameCheck(String[][] playField, String[][] userField) {
        boolean endGame = true;
        for (int i = 0; i < playField.length && endGame; i++) {
            for (int j = 0; j < playField.length; j++) {
                if (userField[i][j].equals("X") && playField[i][j].equals("X")) {
                    endGame = false;
                    break;
                }
            }
        }
        return endGame;
    }

    public String[][] fillUserField(String[][] playField) {
        String[][] arr = new String[9][9];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = playField[i][j];
            }
        }
        return arr;
    }

    public String[][] printField(String[][] arr, String[][] openNum) {
        System.out.println(" │123456789│\n" +
                "—│—————————│");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1 + "│");
            for (int j = 0; j < arr.length; j++) {
                int up = Math.abs(i - 1);
                int down = i + 1 > arr.length - 1 ? i : i + 1;
                int left = Math.abs(j - 1);
                int right = j + 1 > arr.length - 1 ? j : j + 1;
                if (arr[i][j].equals("/")) {
                    System.out.print(arr[i][j]);
                } else if (arr[i][j].equals("X")) {
                    System.out.print(".");
                } else if (arr[i][j].matches("[\\d]") && arr[up][j].equals("/")
                        || arr[down][j].equals("/") || arr[i][left].equals("/")
                        || arr[i][right].equals("/") || arr[up][left].equals("/")
                        || arr[up][right].equals("/") || arr[down][left].equals("/")
                        || arr[down][right].equals("/")) {
                    System.out.print(arr[i][j]);
                    openNum[i][j] = arr[i][j];
                } else if (arr[i][j].equals(".") && openNum[i][j].equals("*")) {
                    System.out.print(openNum[i][j]);
                } else if (arr[i][j].equals(openNum[i][j])) {
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
        return openNum;
    }

    public void printFieldAll(String[][] arr) {
        System.out.println(" │123456789│\n" +
                "—│—————————│");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1 + "│");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j].equals(".") ? "/" : arr[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
    }

    public void userInput(String[][] userField, int r, int c) {
        if (r < 0 || c < 0 || r >= userField.length || c >= userField.length
                || userField[r][c].equals(".") || !userField[r][c].equals("*")) {
            return;
        }

        userField[r][c] = "/";

        userInput(userField, r + 1, c);
        userInput(userField, r - 1, c);
        userInput(userField, r, c + 1);
        userInput(userField, r, c - 1);
    }
}
