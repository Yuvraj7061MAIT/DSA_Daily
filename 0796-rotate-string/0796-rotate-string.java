public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal))
            return true;
        
        int n = s.length();
        
        // Concatenate s with itself to check all possible rotations
        String concatenated = s + s;
        
        // Check if goal is a substring of concatenated s
        return concatenated.contains(goal);
    }
}