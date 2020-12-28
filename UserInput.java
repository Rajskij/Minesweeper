package minesweeper;

public class UserInput {
    String[][] userField;

    public UserInput(String[][] userField) {
        this.userField = userField;
    }

    public void setMark(int x, int y) {
        this.userField[x][y] = "*";
    }

    public boolean endGameCheck (String[][] arr) {
        boolean endGame = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (userField[i][j].equals(".") && arr[i][j].equals("X")) {
                    endGame = false;
                    break;
                }
            }
        }
        return endGame;
    }

    public String[][] fillUserField() {
        for (String[] s : userField) {
            for (String str : s) {
                if (str.equals("X")) {
                    str = ".";
                }
            }
        }
        return this.userField;
    }

    public void printField () {
        System.out.println(" │123456789│\n" +
                "—│—————————│");
        for (int i = 0; i < userField.length; i++) {
            System.out.print(i + 1 + "│");
            for (int j = 0; j < userField.length; j++) {
                System.out.print(userField[i][j].equals("X") ? "." : userField[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
    }
}
