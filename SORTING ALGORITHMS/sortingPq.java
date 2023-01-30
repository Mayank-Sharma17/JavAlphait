public class sortingPq {
    // bubble sort in descending
    public static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) { // turns
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] < arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    // selection sort in descending
    public static void selectionSort(int arr[]) {
        for (int turn = 0; turn < arr.length; turn++) {
            int minPos = turn; // asume curr pos
            for (int j = turn + 1; j < arr.length; j++) {
                if (arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[turn];
            arr[turn] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    // insertion sort in descending
    public static void incertionSort(int arr[]) {
        for (int i = 1; i < arr.length - 1; i++) {
            int curr = i;
            int prev = i - 1;
            // to find the index where curr is to be inserted

            while (prev >= 0 && arr[prev] < curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = curr;
        }

    }

    // counting sort in descending
    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        // bubbleSort(arr);
        // selectionSort(arr);
        // incertionSort(arr);
        countingSort(arr);
        printArr(arr);

    }

}
