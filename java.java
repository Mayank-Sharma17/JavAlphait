

public class java {
    public static void main(String args[]) {

        for (int i = 0; i <= 5; i++) {
            System.out.println("i =" + i);
            
        }
        // here is error is showing because we using the variable 'i' out of the scope means the i is
        // only for the part of { and } fo the for loop.
        // so to remove this erroe we need to declare the variable 'i' out of the scope that is out of
        // the for loop. 
        int i =5;
System.out.println("i after the loop =" + i);
    }
}