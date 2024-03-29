public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        long count = 0; // Changed int to long
        int windowStart = 0;
        int windowEnd = 0;
        int maxCount = 0;

        while (windowEnd < n) {
            if (nums[windowEnd] == maxElement) {
                maxCount++;
            }

            // Shrink the window until maxCount is at least k
            while (maxCount >= k) {
                count += n - windowEnd; // Count subarrays ending at windowEnd
                if (nums[windowStart] == maxElement) {
                    maxCount--;
                }
                windowStart++;
            }

            windowEnd++; // Expand the window
        }

        return count;
    }
}
