import java.util.*;

public class array2Dbasics {
    public static boolean search(int matrix[][], int key) { // for search a key in a matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Found at cell (" + i + "," + j + ")");
                    return true;
                }

            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String args[]) {

        // representati on of 2D array : a matrix
        int matrix[][] = new int[3][3]; // this is size: 3*3 2D array/matrix, Total 9 cells = n*m
        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in); // input elements
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println(); // next line after every row
        }
        sc.close();
        search(matrix, 5); 
    }

}
