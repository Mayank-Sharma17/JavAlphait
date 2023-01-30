import java.util.ArrayList;

public class MultiArrlist { 
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1); list.add(2);
        // mainlist.add(list);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3); list2.add(4);
        // mainlist.add(list2);

        // for(int i=0; i<mainlist.size(); i++) {
        //     ArrayList<Integer> currlist = mainlist.get(i);
            
        //     for(int j=0; j<currlist.size(); j++) {
        //         System.out.print(currlist.get(j)+ " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(mainlist);

        ArrayList<Integer> list1 = new ArrayList<>(); // 1 2 3 4 5
        ArrayList<Integer> list2 = new ArrayList<>(); // 1 4 6 8 10
        ArrayList<Integer> list3 = new ArrayList<>(); // 3 6 9 12 15

        for(int i=1; i<=5; i++) { // adding elements to list
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }

        mainlist.add(list1); // added lists in main list
        mainlist.add(list2);
        mainlist.add(list3);

        System.out.println(mainlist);

            // nested loops 
        for(int i=0; i<mainlist.size(); i++) { 
            ArrayList<Integer> currlist = mainlist.get(i);
        
            for(int j=0; j<currlist.size(); j++) {
               System.out.print(currlist.get(j)+ " ");
            }
            System.out.println();
        }
        
    }
    
}
