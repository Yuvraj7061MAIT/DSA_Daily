class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxSoFar;
            maxSoFar = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
            minSoFar = Math.min(nums[i], Math.min(temp * nums[i], minSoFar * nums[i]));
            maxProduct = Math.max(maxProduct, maxSoFar);
        }

        return maxProduct;
    }
}
