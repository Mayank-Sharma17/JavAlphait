package HASHING;
import java.util.*;

public class IterateonHS {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        Iterator it = cities.iterator(); // return a valid iterator for set
        while(it.hasNext()) { // it is aage koe esa element ho jo traverse na hua ho use check kreaga hasnext function
            System.out.println(it.next()); // it update bhe hojaega or next vala print bhe hojaega
        }

        // using enhanced loop
        for(String city : cities) {
            System.out.println(city);
        }
    }
}
