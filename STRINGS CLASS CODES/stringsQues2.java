public class stringsQues2 {
    public static String toUpperCase(String str) { // O(n)
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == ' ' && i < str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString(); 
    }

    public static String compress(String str) { // O(n)
        String newStr = "";

        for(int i=0; i<str.length(); i++) {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }

    // public static String sbcompress(String str) {
    //     StringBuilder output = new StringBuilder("");
    //     //String ch = str.charAt(0) + "";
    //     int count = 1;
    //     for(int i=0; i<str.length(); i++) {
    //         char curr = str.charAt(i);
    //         char prev = str.charAt(i - 1);

    //         if(curr == prev) {
    //             count++;
    //         } else {
    //             if(count > 1) {
    //             output.append(count+"");
    //             count = 1;
    //             }
    //             output.append(curr+"");
    //         }
    //     }
    //     if(count > 1) {
    //         output.append(count+"");
    //         count = 1;
    //     } 
    //     return output.toString();       
    // }
    public static void main(String args[]) {
        // String fruits[] = { "apple", "mango", "banana" }; // print largest string - Lexicographic order
        // String largest = fruits[0];

        // for (int i = 1; i < fruits.length; i++) {
        //     if (largest.compareTo(fruits[i]) < 0) {
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest); // O(x*n)

       
        // STRING BUILDER
        // StringBuilder sb = new StringBuilder(""); // sb.toString()-covert object(Integer) to String
        // for(char ch='a'; ch<='z'; ch++) {
        //     sb.append(ch); // String ke pechee jodne ke lea
        // }
        // System.out.println(sb); // O(26)


        // String str = "hi, i am mayank";
        // System.out.println(toUpperCase(str));


        String str = "aaabbcccdd";
        System.out.println(compress(str));
    }

}
