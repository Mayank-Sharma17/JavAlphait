public class Recursion {
    public static void printDec(int n) { // print dec from n to 1
        if(n == 1) { // Base Class 
            System.out.println(1);
            return;
        }
        System.out.print(n+ " "); // this print our 10
        printDec(n-1); // asuume this will print 9 to 1
    }

    public static void printInc(int n) { // print inc from n to 1
        if(n == 1) {
            System.out.print(n+ " ");
            return;
        }
        printInc(n-1);
        System.out.print(n+ " ");
    }
 
    public static int fact(int n) { // calculating factorial 
        if( n == 0) { // we know 0! = 1
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n * fnm1;
        return fn;
    }

    public static int calcSum(int n) { // calculating sum of n natural no.
        if( n == 1) {
            return 1;
        }
        int Snm1 = calcSum(n-1);
        int Sn = n + Snm1;
        return Sn;
    }

    public static int fib(int n) { // print Nth fibonacci no. 0 1 1 2 3 5 8 13.....
        if( n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[], int i) { //check given arr is sorted or not
        if( i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int key, int i) { // finding first Occurence in arr
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i) { // finding last Occurence in arr
        if(i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }
    public static void main(String args[]) {
        //int n = 5;
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println(lastOccurence(arr, 5, 0)); // compare form i- 0th index      
    }

}
