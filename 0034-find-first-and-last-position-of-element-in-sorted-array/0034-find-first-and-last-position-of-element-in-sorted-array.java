class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int leftIndex = findLeftIndex(nums, target);
        int rightIndex = findRightIndex(nums, target);
        
        result[0] = leftIndex;
        result[1] = rightIndex;
        
        return result;
    }
    
    private int findLeftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
    
    private int findRightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
