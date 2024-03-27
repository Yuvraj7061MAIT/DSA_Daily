class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // If k <= 1, product will always be less than k

        int product = 1;
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            // At each step, the number of subarrays ending at right is right - left + 1
            count += right - left + 1;
        }

        return count;
    }
}
