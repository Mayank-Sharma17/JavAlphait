public class array2Dpractice {
    public static void printmatrix(int matrix[][]) {
        System.out.println(" The matrix is :");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        // int arr[][] = { { 4, 7, 8 },
        //         { 8, 8, 7 } };

        // int count = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {

        //         if (arr[i][j] == 7) {
        //             count++;
        //         }
        //     }
        // }
        // System.out.println(" the number of 7s is: " + count);

        
    //     int nums[][] = {{1,4,9},
    //                     {11,4,3},
    //                     {2,2,3}};
    //     int sum = 0;
    //    // sum od second row elements
    //     for(int j=0; j<nums[0].length; j++) {
    //         sum += nums[1][j];
    //     }
    //     System.out.println("Sum of second row is :" + sum);  
    
    
         int[][] matrix = { {2, 3, 7}, {5, 6, 7} };
         int row = 2, column = 3;

         // diplay the matrix
         printmatrix(matrix);

         // transpose the matrix
         int transpose[][] = new int[column][row];
         for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                transpose [j][i] = matrix[i][j];
            }
         }
         // print the tansposed matrix
         printmatrix(transpose);

    }    
}
