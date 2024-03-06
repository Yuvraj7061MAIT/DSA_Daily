class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // If the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target is within the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // If the right half is sorted
                // Check if target is within the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        // If target is not found, return -1
        return -1;
    }
}
