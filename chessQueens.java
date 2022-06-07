import java.util.Arrays;

public class chessQueens {
    public static void main(String[] args) {
        int[][] desk = {{0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0}};
        
        if (!queensPos(desk, 0)) {
            System.out.println("Решения нет");
            return;
        }

        for (int i = 0; i < desk.length; i++) {
            for(int j = 0; j < desk.length; j++) {
                System.out.print(desk[i][j] + " ");
            }
            System.out.println();
        }

        // System.out.println(Arrays.deepToString(desk));
    }

    public static boolean checkPos(int[][] board, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1)
                return false;
            // проверка налево

        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
            // проверка по диагонали налево вверх

        }

        for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
            // проверка по диагонали налево вниз
        }

        return true;
    }

    public static boolean queensPos(int[][] board, int col) {
        if (col >= board.length) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (checkPos(board, i, col)) {
                board[i][col] = 1;

                if (queensPos(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }

        return false;
    }
}
