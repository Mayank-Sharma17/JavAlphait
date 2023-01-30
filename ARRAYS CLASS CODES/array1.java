

public class array1 {
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) { // matlb i 0 se marks ke length tak jaega
            marks[i] = marks[i] + 1;
        }

    }

    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }

        }
        return -1;
    }

    public static int getlargest(int numbers[]) {
        int largest = Integer.MIN_VALUE; // storing '-infinity' in largest variable
        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }
        return largest;
    }

    public static void main(String args[]) {
        // int marks[] = { 97, 98, 99 };
        // update(marks); // passing array as an argument >>> call by reference

        // // print our marks
        // for (int i = 0; i < marks.length; i++) {
        // System.out.print(marks[i] + " ");
        // }
        // System.out.println();

        
        // int numbers[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        // int key = 10;

        // int index = linearSearch(numbers, key);
        // if (index == -1) {
        // System.out.println("NOT found");
        // } else {
        // System.out.println("key is at index :" + index);
        // }

        
        int numbers[] = {1,2,6,8,5};
        System.out.println("largest value is :" + getlargest(numbers));

    }

}
