import java.util.*;
public class Strings {

    public static void printLetters(String str) {
        for(int i=0; i<str.length(); i++) {
           System.out.println(str.charAt(i)+" ");
        }
     System.out.println();
    }
    public static void main(String args[]) {
        // char arr[] = {'a','b','c','d'};

        // String str = "abcd";
        // String str2 = new String("xyz"); // or 

        // *java Strings are IMMUTABLE

        // input
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine(); // sc.next()- only take single word nextLine take complete line
        System.out.print(name);

        // length of string
        String FullName = "Mayank Sharma";
        System.out.println(FullName.length()); 

        // Concatenation
        String firstName = "Mayank";
        String lastName = "Sharma";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        // String charAt method
        System.out.println(fullName.charAt(0)); // it will print M at O index

        // printing all letters in string
        printLetters(FullName);
sc.close();
    }
    
}
