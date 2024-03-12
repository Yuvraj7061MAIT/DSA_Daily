class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                // If the element at mid is greater than the next element,
                // a peak might be to the left or at mid itself.
                right = mid;
            } else {
                // If the element at mid is less than or equal to the next element,
                // a peak might be to the right of mid.
                left = mid + 1;
            }
        }
        
        // At the end of the loop, left and right will converge to a peak element.
        return left;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak element index for nums1: " + solution.findPeakElement(nums1)); // Output: 2
        
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak element index for nums2: " + solution.findPeakElement(nums2)); // Output: 5
    }
}
