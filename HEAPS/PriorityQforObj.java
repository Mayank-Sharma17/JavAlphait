package HEAPS;
import java.util.*;

public class PriorityQforObj {
    // PQ for Objects
    static class students implements Comparable<students> { // to compare objects of class
        String name;
        int rank;
        
        public students(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        @Override // parent class ya interface se jab koe function aata hai or usko child class bhe implement krete hai that is overriding
        public int compareTo(students s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<students> pq =  new PriorityQueue<>(); // JCF <Integer> ghatega to priority bhadega ascending
        // if we need to out in descending order use Comparator.reverseOrder()
        // PriorityQueue<Integer> pq1 =  new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new students("A", 4));
        pq.add(new students("B", 5));
        pq.add(new students("C", 2));
        pq.add(new students("D", 12));
        
        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name +"->"+ pq.peek().rank);
            pq.remove();
        }
    }
}
