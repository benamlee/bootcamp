import java.util.Arrays;

class Sudoku {

    public static void main(String[] args) {
        char[][]board={{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);
        System.out.println(Arrays.toString(board));
    }


    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '0'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (!(isRow(board) && isColumn(board) && is9(board))) {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public static boolean isRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (j != k) {
                        if (board[i][j] == board[i][k]) {
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }

    public static boolean isColumn(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (j != k) {
                        if (board[j][i] == board[k][i]) {
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }

    public static boolean is9(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0 + 3 * i; k < 3 + 3 * i; k++) {
                    for (int l = 0 + 3 * j; l < 3 + 3 * j; l++) {
                        for (int m = 0 + 3 * i; m < 3 + 3 * i; m++) {
                            for (int n = 0 + 3 * j; n < 3 + 3 * j; n++) {
                                if (m != k && n != l
                                        && board[k][l] == board[m][n]) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }



}
