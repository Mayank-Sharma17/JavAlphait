public class BacktrackArr {

    public static void changeArr(int arr[], int i, int val) { // time and space comp = O(n)
        // base case
        if(i == arr.length) {
            printArr(arr); // output > 1 2 3 4 5
            return;
        }

        // recursion
        arr[i] = val; 
        changeArr(arr, i+1, val+1); // fxn call
        arr[i] = arr[i]-2; // backtrack step
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr); // output > -1 0 1 2 3 
    }
}