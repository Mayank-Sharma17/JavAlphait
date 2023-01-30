package HASHING;
import java.util.*;

public class Implementation {
    static class HashMp<K, V> { // generics parameterized type matlb type kuch be hosaka hai
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n no. of nodes
        private int N;
        private LinkedList<Node> buckets[]; //N= buckets.length arr of ll

        @SuppressWarnings("unchecked")
        public HashMp() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        // from above till here is given

        private int hashFunction(K key) {
            int hc = hashCode(); // it gives a hash code like 12345 or -12345
            // we have to take the absolute value of hc and must in the range of o to buckets.size()-1
            return Math.abs((hc)%N); // now it will give a valid bi
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0; // intitalizing the data idx with 0

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2]; 
            N = 2*N;
            
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes->add in buckets
            for(int i=0; i<oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }           
        }

        public void put(K key, V value) { // O(lambda)= O(1)
            int bi = hashFunction(key); // bucket idx
            int di = SearchInLL(key, bi); // search on LL to return idx of data

            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++; // count of nodes incremented
            }

            // rehash???
            double lambda = (double)n/N; // threshold
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) { // O(1)
            int bi = hashFunction(key); // bucket idx
            int di = SearchInLL(key, bi); // search on LL to return idx of data

            if(di != -1) {
               return true;
            } else {
                return false;
            }
        }

        public V get(K key) { // O(1)
            int bi = hashFunction(key); // bucket idx
            int di = SearchInLL(key, bi); // search on LL to return idx of data

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) { // O(1)
            int bi = hashFunction(key); // bucket idx
            int di = SearchInLL(key, bi); // search on LL to return idx of data

            if(di != -1) {
                Node node = buckets[bi].get(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> KeySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];

                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMp<String, Integer> hm = new HashMp<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.KeySet(); // working - 
        for (String key : keys) {
            System.out.println(key);
        }
 
        System.out.println(hm.get("India")); // working -
        System.out.println(hm.isEmpty());

        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}
