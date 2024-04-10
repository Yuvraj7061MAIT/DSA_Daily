import java.util.*;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        
        // Initialize two pointers for positive and negative numbers
        int posIndex = 0, negIndex = 1;
        
        // Create an array to store the rearranged elements
        int[] rearranged = new int[n];
        
        // Place positive numbers at even indices and negative numbers at odd indices
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                rearranged[negIndex] = nums[i];
                negIndex += 2;
            } else {
                rearranged[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        
        return rearranged;
    }
}
