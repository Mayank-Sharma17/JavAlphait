
// INBUILT SORT -  to use this sort you have to import this as shown below
//import java.util.Arrays; // arange in ascending order
//import java.util.Collections; // if we want to sort in descending order using INBUIT sort import this

public class Sorting {
    public static void bubbleSort(int arr[]) { // T.C = O(n^2)
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    public static void selectionSort(int arr[]) { // T.C = O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i; // assume our min position is current value at i index
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) { // out is in accending sort if we change '<' it will print in decending sort
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int arr[]) { // T.C = O(n^2)
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) { // finding correct position to instert
                arr[prev + 1] = arr[prev];
                prev--;

            }
            // insertion
            arr[prev + 1] = curr;
        }
    }

    public static void countingSort(int arr[]) { // T.C ~ n/nlogn better for small elements large in quantity
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);

        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int arr[]) { // function for printing our array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 5, 4, 1, 3, 2 };
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        //countingSort(arr);

        // Arrays.sort(arr); // by default this will sort the arr in ascending order
        // T.C=O(nlogn) < O(n^2)
        // Arrays.sort(arr, 0,3); // fromindex toindex matlb hame sirf index 0 se 2*
        // hame index 0 se 2 tak sort karna hai to last vaala index ko +1 krna hoga jase
        // 2 tak krna hai to 0 to 3 pass krna hoga ke beech vala sort karna hoo

        // Arrays.sort(arr, Collections.reverseOrder()); // here sort showing error
        // because it will work on object like Integer not int so we have to replace
        // with Integer to work this sort
        // Arrays.sort(arr, si , ei , Collections.reverseOrder()); // starting index or
        // ending index matlb yaha se yaha tak sirf sort karna hai, not wrk on
        // primitive/ basic typr var

        printArr(arr);
    }

}
