package Advanced.BackTrace;

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] sqUsed = new boolean[3][3][10];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    sqUsed[i/3][j/3][num] = true;
                }
            }
        }

        dfs(board, rowUsed, colUsed, sqUsed, 0, 0);
    }

    public boolean dfs(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] sqUsed, int row, int col) {
        if (col == 9) {
            col = 0;
            row ++;
            if (row == 9) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for (int num = 1; num < 10; num++) {
                boolean canUse = !rowUsed[row][num] && !colUsed[col][num] && !sqUsed[row / 3][col / 3][num];
                if (canUse) {
                    board[row][col] = (char) (num + '0');
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    sqUsed[row / 3][col / 3][num] = true;
                    if (dfs(board, rowUsed, colUsed, sqUsed, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    sqUsed[row / 3][col / 3][num] = false;
                }
            }
        }
        else {
            return dfs(board, rowUsed, colUsed, sqUsed, row, col + 1);
        }
        return false;
    }
}
