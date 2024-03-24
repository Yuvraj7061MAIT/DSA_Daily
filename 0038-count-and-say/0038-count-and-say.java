public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1"; // Base case
        }
        
        String prev = countAndSay(n - 1); // Recursively obtain the (n-1)th term
        
        StringBuilder result = new StringBuilder(); // Initialize StringBuilder to store the current term
        
        int count = 1; // Initialize count for current digit
        char digit = prev.charAt(0); // Initialize current digit
        
        // Iterate through the (n-1)th term to generate the nth term
        for (int i = 1; i < prev.length(); i++) {
            char currentDigit = prev.charAt(i);
            if (currentDigit == digit) {
                count++; // Increment count if current digit is the same as the previous one
            } else {
                result.append(count); // Append count
                result.append(digit); // Append digit
                digit = currentDigit; // Update current digit
                count = 1; // Reset count for new digit
            }
        }
        
        // Append the last count and digit
        result.append(count);
        result.append(digit);
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage:
        System.out.println(solution.countAndSay(1)); // Output: "1"
        System.out.println(solution.countAndSay(4)); // Output: "1211"
    }
}
