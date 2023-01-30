public class N_Knight {
    static int count = 0;

    public static void nKnight(char[][] board, int row) {
        // base case
        if(row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        // column
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) { // check the position of kinghts is safe or not
                board[row][j] = 'K';
                nKnight(board, row+1); // fxn call
                board[row][j] = 'x'; // backtrack step
            }
        }
    }

    public static boolean isSafe( char[][] board, int row, int col) {
        // 4 positions 
        if(isValid(board, row-2, col-1)) {
           if(board[row-2][col-1] == 'K') {
             return false;
           }
        }
        if(isValid(board, row-2, col+1)) {
           if(board[row-2][col+1] == 'K') {
             return false;
           }
        }
        if(isValid(board, row-1, col+2)) {
            if(board[row-1][col+2] == 'K') {
              return false;
            }
        }
        if(isValid(board, row-1, col-2)) {
            if(board[row-1][col-2] == 'K') {
              return false;
            }
        }
        return true;
    }
    static boolean isValid(char[][] board, int row, int col) {
        if(row >=0 && row<board.length && col>=0 && col<board.length) {
            return true;
        }
        return false;
    }

    public static void printBoard(char board[][]) {
        System.out.println("-----------Chess Board-----------");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 3;
        char board[][] = new char[n][n];
        // initialize
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board [i][j] = 'x';
            }
        }
        nKnight(board, 0);
        System.out.println("no of board =" +count);
    }
    
}
