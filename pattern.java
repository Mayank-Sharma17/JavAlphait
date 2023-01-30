
public class pattern {
    public static void palindromicPattern(int n) {
        // outer
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // decending
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            // ascending
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void numberPyramid(int n) {
        // outer loop
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void diamond(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // hollow rect-- for stars
            for (int j = 1; j <= n; j++) {

                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        // first half
        for (int i = 1; i <= n; i++) {
            // stars -- i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces -- 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // stars -- i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // second half
        for (int i = n; i >= 1; i--) {
            // stars -- i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces -- 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // stars -- i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void zero_one_triangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void Floyds_triangle(int n) {
        // outer
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            // inner loop
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void inverted_half_pyramid_with_numbers(int n) {
        for (int i = 1; i <= n; i++) {
            // inner loop
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }

    public static void inverted_rotated_half_pyramid(int n) {
        for (int i = 1; i <= n; i++) {// outer loop--- lines
            for (int j = 1; j <= n - i; j++) { // spaces

                System.out.print(" ");
            }
            // stars lines=stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rectangle(int totRows, int totCols) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // inner loop
            for (int j = 1; j <= totCols; j++) {
                // cell (i,j)
                if (i == 1 || i == totRows || j == 1 || j == totCols) { // boundary cell
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {

        // hollow_rectangle(4,5);
        // inverted_rotated_half_pyramid(10);
        // inverted_half_pyramid_with_numbers(20);
        // Floyds_triangle(15);
        // zero_one_triangle(5);
        // butterfly(15);~
        // solid_rhombus(5);
        // hollow_rhombus(10);
        // diamond(15);
        // numberPyramid(5);
        palindromicPattern(5);
    }

}
