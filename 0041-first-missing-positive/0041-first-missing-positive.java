public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Rearrange the array such that each positive integer is placed at index num - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Step 2: Traverse the array to find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // Missing positive integer found
            }
        }

        // If all positive integers in the range [1, n] are present, return n + 1
        return n + 1;
    }

    // Helper function to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
