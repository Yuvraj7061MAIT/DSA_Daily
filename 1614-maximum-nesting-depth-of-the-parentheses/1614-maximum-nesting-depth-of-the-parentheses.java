class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0; // Initialize the maximum nesting depth
        int currentDepth = 0; // Initialize the current nesting depth

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') { // If the character is an opening parenthesis
                currentDepth++; // Increment the current nesting depth
                maxDepth = Math.max(maxDepth, currentDepth); // Update the maximum depth if needed
            } else if (c == ')') { // If the character is a closing parenthesis
                currentDepth--; // Decrement the current nesting depth
            }
        }

        return maxDepth; // Return the maximum nesting depth
    }
}
