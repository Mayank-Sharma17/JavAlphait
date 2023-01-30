import java.util.ArrayList;

public class ReverseArrlist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
                    list.add(1);
                    list.add(2);
                    list.add(3); 
                    list.add(4);
                    list.add(5);
            System.out.println(list);
        for(int i = list.size()-1; i>=0; i--) { // reverse of an AL
            System.out.print(list.get(i)+ " ");  
        }
        System.out.println();
    }
    
}
