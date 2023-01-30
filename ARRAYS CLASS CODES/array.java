import java.util.*;

public class array {
    public static void main(String args[]) {        //BASICS OF ARRAYS

        int marks[] = new int[100];           // INPUT
        Scanner sc = new Scanner(System.in);

        marks[0] = sc.nextInt(); // phy                  assume marks[0/1/2...] as var
        marks[1] = sc.nextInt(); // chem
        marks[2] = sc.nextInt(); // math
        
        // print the marks
        System.out.println("phys :" + marks[0]);
        System.out.println("chem :" + marks[1]);     // OUTPUT
        System.out.println("math :" + marks[2]);

        // for upadate the marks
        marks[2] = 100; // to increase the marks by one we can also write mark[2] = marks[2]+1;
        System.out.println("math :" + marks[2]);

        // for calculating the percentage
        int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("percentage is :" + percentage + "%");

        // for length of an array
        System.out.println("length of an array =" + marks.length);
sc.close();
    }
}