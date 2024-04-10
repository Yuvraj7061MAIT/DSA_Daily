import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the indices of elements
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];
            
            // If complement is present in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Otherwise, put the current element and its index in the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array
        return new int[0];
    }
}
