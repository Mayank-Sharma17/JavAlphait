import java.util.*;

public class stringsPractice {
    public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in); 
//         String yourString;
//         yourString = sc.nextLine();

//         int count = 0; // for counting vowels in yourString

//         for (int i = 0; i < yourString.length(); i++) {
//             char ch = yourString.charAt(i);

//             if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'o' || ch == 'u') {
//                 count++;
//             }           
//         }
//         System.out.println("Count of vowels in lowercase is: "+ count);      
// sc.close();         


        String str1 = "earth";
        String str2 = "heart";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()) {
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();

            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            boolean result = Arrays.equals(str1charArray, str2charArray);

            if(result) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other. ");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other. ");
            }
        }
    }
}
