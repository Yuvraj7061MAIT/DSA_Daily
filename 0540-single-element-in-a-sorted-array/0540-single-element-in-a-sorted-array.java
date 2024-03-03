class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Ensure mid is even
            if (mid % 2 == 1) {
                mid--;
            }
            
            // Check if the single element is to the left or right of mid
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        
        // At the end, left will be pointing to the single element
        return nums[left];
    }
}
