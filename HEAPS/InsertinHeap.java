package HEAPS;

import java.util.ArrayList;

public class InsertinHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(logn)
            // add at last index
            arr.add(data);

            int x = arr.size()-1; // x child index
            int par = (x-1)/2; // parent index

            while(arr.get(x) < arr.get(par)) {
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par; // updata child and parenet pointer
                par = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0); // min value jo ke 0th idx pr hoge
        }

        private void heapify(int i) { // O(logn) this function is for fixing our heap 
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if(minIdx != i) { // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() { // delete min elemente T.C log(n)
            int data = arr.get(0); // O(1)

            // step-1 swap 1st and last ele
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step-2 delete last
            arr.remove(arr.size()-1); // O(1)

            //step-3 heapify O(logn)
            heapify(0);
            
            return data;
        }

        public boolean isEmpty() { //  to check if heap is empty or not
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        //create Heap
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
