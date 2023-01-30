package HEAPS;

public class HeapSort {

    public static void heapSort(int arr[]) { // T C O(nlogn)
        // step 1 build max heap
        int n = arr.length;
        for(int i=n/2; i>=0; i--) {
            heapify(i, arr, n);
        }

        // step 2 push laregst element at last
        for(int i=n-1; i>0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0, arr, i);
        }
    }

    public static void heapify(int i, int arr[], int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if(maxIdx != i) {
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(maxIdx, arr, size);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};
        heapSort(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    } 
}
