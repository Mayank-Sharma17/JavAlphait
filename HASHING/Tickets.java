package HASHING;
import java.util.*;

public class Tickets {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revmap = new HashMap<>();
        for(String key : tickets.keySet()) { 
            revmap.put(tickets.get(key), key);
        }
        for(String key : tickets.keySet()) { // tickets mae exist krta hai or revmap mae nahe krta
            if(!revmap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.println(start);

        for(String key : tickets.keySet()) {
            System.out.print("->"+tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
