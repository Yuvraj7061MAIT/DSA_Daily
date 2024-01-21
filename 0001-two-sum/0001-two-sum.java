import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the complement of each number and its index
        Map<Integer, Integer> complementMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            // Check if the complement is already in the map
            if (complementMap.containsKey(complement)) {
                // If found, return the indices of the two numbers
                return new int[]{complementMap.get(complement), i};
            }

            // Otherwise, add the current number and its index to the map
            complementMap.put(currentNum, i);
        }

        // If no solution is found, return an empty array
        return new int[]{};
    }
}