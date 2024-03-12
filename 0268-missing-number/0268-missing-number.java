class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Calculate the expected sum of the first n natural numbers
        int expectedSum = n * (n + 1) / 2;
        
        // Calculate the actual sum of the elements in nums
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }
        
        // The difference between the expected sum and the actual sum
        // will be the missing number
        return expectedSum - actualSum;
    }
}
