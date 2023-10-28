package lab_5;

public class Tic_Tac_Toe {
    private static final char EMPTY = ' ';
    private char[][] board;

    public Tic_Tac_Toe(int n) {
        this.board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    //checkRows
    public boolean checkRows() {
        if (board.length != board[0].length) return false;
        else {
            for (int i = 0; i < board.length; i++) {
                int j = 0;
                for (int k = 0; k < board[0].length; k++) {
                    if (board[i][k] != EMPTY) {
                        if (board[i][i] == board[i][k]) {
                            j++;
                        }
                    }
//                System.out.println(j);
                    if (j == board[i].length) return true;
                }
            }
        }
        return false;
    }

    //checkColumns()
    public boolean checkColumn() {
        if (board.length != board[0].length) return false;
        else {
            for (int i = 0; i < board.length; i++) {
                int j = 0;
                for (int k = 0; k < board[i].length; k++) {
                    if (board[i][k] != EMPTY) {
                        if (board[i][i] == board[k][i]) {
                            j++;
                        }
                    }
//                System.out.println(j);
                    if (j == board.length) return true;
                }
            }
        }
        return false;
    }

    //checkDiagonals()
    public boolean checkDiagonals() {
        if (board.length != board[0].length) return false;
        else {
            for (int i = 0; i < board.length; i++) {
                int j = 0;
                if (board[i][i] != EMPTY) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[i][i] == board[k][k]) {
                            j++;
                        }
                    }
                }
                int s=0;
                if(board[i][i]!=EMPTY){
                    for (int k=0;k< board.length;k++){
                        if(board[i][board.length-1-i]== board[k][board.length-1-k]){
                            s++;
                        }
                    }
                }
                System.out.println(j);
                if (j == board.length||s==board.length) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Tic_Tac_Toe test = new Tic_Tac_Toe(3);
        char[][] t = {{'X', 'O', 'O'}, {'O', 'O', 'X'}, {'O', 'O', 'O'}};
        test.setBoard(t);
//        System.out.println(test.checkRows());
//        System.out.println(test.checkColumn());
        System.out.println(test.checkDiagonals());
    }

}
