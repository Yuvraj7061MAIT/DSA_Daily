public class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);
        
        // Keep repeating string a until its length is greater than or equal to b
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        // Check if string b is a substring of the repeated string a
        if (sb.indexOf(b) != -1) {
            return count;
        }
        
        // If not, check one more repetition
        if (sb.append(a).indexOf(b) != -1) {
            return count + 1;
        }
        
        // If still not found, return -1
        return -1;
    }
}