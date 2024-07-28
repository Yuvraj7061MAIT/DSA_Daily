class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        // Initialize the memo array with -1 to indicate that the value has not been computed
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        return robHelper(nums, 0, memo);
    }
    
    public int robHelper(int[] nums, int i, int[] memo) {
        // If index is out of bounds, no money can be robbed
        if (i >= nums.length) {
            return 0;
        }
        
        // If the result for this index is already computed, return it
        if (memo[i] != -1) {
            return memo[i];
        }
        
        // Case 1: Rob the current house and skip the next one
        int robCurr = nums[i] + robHelper(nums, i + 2, memo);
        
        // Case 2: Skip the current house and move to the next one
        int skipCurr = robHelper(nums, i + 1, memo);
        
        // Store the result in the memo array and return the maximum of the two cases
        memo[i] = Math.max(robCurr, skipCurr);
        return memo[i];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Maximum amount of money to rob: " + sol.rob(nums1)); // Output: 4
        
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Maximum amount of money to rob: " + sol.rob(nums2)); // Output: 12
    }
}
