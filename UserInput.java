package minesweeper;

public class UserInput {
    String[][] userField;

    public UserInput(String[][] playField) {
        this.userField = playField;
    }

    public void setMark(int x, int y) {
        userField[x][y] = userField[x][y].equals("*") ? "." : "*";
    }

    public boolean endGameCheck (String[][] arr) {
        boolean endGame = true;
        for (int i = 0; i < arr.length && endGame; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (userField[i][j].equals(".") && arr[i][j].equals("X")) {
                    endGame = false;
                }
            }
        }
        return endGame;
    }

    public void fillUserField(String[][] str) {
        for (int i = 0; i < userField.length; i++) {
            for (int j = 0; j < userField.length; j++) {
                if (str[i][j].equals("X")) {
                    userField[i][j] = ".";
                } else {
                    userField[i][j] = str[i][j];
                }
            }
        }
    }

    public void printField () {
        System.out.println(" │123456789│\n" +
                "—│—————————│");
        for (int i = 0; i < userField.length; i++) {
            System.out.print(i + 1 + "│");
            for (int j = 0; j < userField.length; j++) {
                System.out.print(userField[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
    }
}
