import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int count = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        while (right < n) {
            // Expand the window and update frequency map
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);
            right++;
            
            // Shrink the window until the number of distinct elements is greater than k
            while (frequencyMap.size() > k) {
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
                if (frequencyMap.get(nums[left]) == 0) {
                    frequencyMap.remove(nums[left]);
                }
                left++;
            }
            
            // Update the count of good subarrays
            count += right - left;
        }
        
        return count;
    }
}
