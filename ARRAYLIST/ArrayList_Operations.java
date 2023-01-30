import java.util.ArrayList;

public class ArrayList_Operations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
                    list.add(1);
                    list.add(2);
                    list.add(3); // [1 2 3 4 5] our list  O(1)
                    list.add(4);
                    list.add(5);
        // another particular fuxn to add element
        list.add(0, 20); // to store 20 at 0th index
        System.out.println(list); // [20 1 2 3 4 5]  O(n)
                    
        System.out.println(list.get(2)); // 3  O(1)

        list.remove(1); 
        System.out.println(list); // [1 3 4 5]  O(n)

        list.set(1, 10); 
        System.out.println(list); // [1 10 4 5]  O(n)

        // to check if element exist in arrL or not O(n)
        System.out.println(list.contains(5)); // true
        System.out.println(list.contains(50)); // false 

        // Size of ArrayList
        System.out.println(list.size());
        // we can also apply loops for Al
        // if(int i=0; i<list.size(); i++) {
        //     Soutln(list.get(i)+ " ");
        // }

    }
    
}
