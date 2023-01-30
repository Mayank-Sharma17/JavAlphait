
public class loop1 {
    public static void main(String args[]) {
// star pattern
// *
// **        like this 
// ***
// ****
        for (int line = 1; line <= 20; line++) {

            for (int star = 1; star <= line; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}