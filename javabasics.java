import java.util.*;

public class javabasics {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

float pencil = sc.nextFloat();
float pen = sc.nextFloat();
float eraser = sc.nextFloat();

float total = pencil+pen+eraser;

System.out.println("your bill is " +total);

sc.close();


    }
}