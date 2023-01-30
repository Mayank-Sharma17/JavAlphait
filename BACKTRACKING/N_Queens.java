// place N queens on an n*n chessboard such that queens can't attack each other

public class N_Queens {

    public static void nQueens(char board[][], int row) {
        // base case
        if(row == board.length) {
            count++;
            printBoard(board);
            return;
        }
        // column 
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) { // check the position of queen is safe or not
                board[row][j] = 'Q';
                nQueens(board, row+1); // fxn call
                board[row][j] = 'x'; // backtrack step
            }          
        }
    }

    static int count = 0;

    public static boolean isSafe(char board[][], int row, int col ) {
        // vertically up
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonaly left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j-- ) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonaly right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++ ) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
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
        int n = 10;
        char board[][] = new char[n][n];
        // initialize
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board [i][j] = 'x';
            }
        }
        nQueens(board, 0);
        System.out.println("total no of ways to solve n queens = "+ count);
    }
}
// time comp. O(n!) --- 1Q-n choices 2Q-n-1..
