public class RemoveDupicates {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base class
        if( idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // kaam
        char currchar = str.charAt(idx);
        if(map[currchar - 'a'] == true) { // checking if this char present in map or not- if true  
            // Duplicate
            removeDuplicates(str, idx+1, newStr, map); // don't add in newStr go for next char
        } else {
            map[currchar - 'a'] = true; // if not then add that char in newStr 
            removeDuplicates(str, idx+1, newStr.append(currchar), map);
        }

    }

    public static void main(String args[]) {
        String str = "mayanksharma";
        removeDuplicates(str, 0, new StringBuilder(""),new boolean[26]);
    }
    
}
