public class interviewques2Darray {
    public static void Spiralmatrix(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");

            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");

            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }

    public static int diagonalSum(int matrix[][]) { // brute force O(n^2)
        int sum = 0;
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         // primary diagonal
        //         if (i == j) {
        //             sum += matrix[i][j];
        //         }
        //         // secondary diagonal
        //         else if (i + j == matrix.length - 1) {
        //             sum += matrix[i][j];

        //         }
        //     }
        // }
        // return sum;
        
        for(int i=0; i<matrix.length; i++) { // O(n) 
            // PD
            sum += matrix[i][i];
            // SD
            if(i != matrix.length-1-i) { // if conditon covers overlaping elem case
               sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }

    public static boolean staircaseSearch(int matrix[][],int key) { // T.C = O(n+m) because T.C depends on the no. of rows and columns if n>>m tc=O(n) and vice versa
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == key) {
                System.out.println("Key found at cell (" + row + "," + col + ")");
                return true;
            }
            else if(key < matrix[row][col]) { // matrix[row][col] < cell value
                col--; // LEFT
            }
            else{
                row++; // BOTTOM
            }
        }
        System.out.println("Key not found ");
        return false;
    }
    public static void main(String args[]) {
        // int matrix[][] = { { 1, 2, 3, 4, },
        //                    { 5, 6, 7, 8 },
        //                    { 9, 10, 11, 12 },
        //                    { 13, 14, 15, 16 } };
        // Spiralmatrix(matrix);
        // System.out.println(diagonalSum(matrix));

        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};
        int key = 33;
        
        staircaseSearch(matrix, key);

    }

}
