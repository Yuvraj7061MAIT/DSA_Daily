class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Ensure nums1 is smaller than or equal to nums2
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int left = 0;
        int right = m;
        int totalLen = m + n;
        
        while (left <= right) {
            int partitionX = left + (right - left) / 2;
            int partitionY = (totalLen + 1) / 2 - partitionX;
            
            // Handling edge cases without ternary operators
            int maxX, minX, maxY, minY;

            if (partitionX == 0) {
                maxX = Integer.MIN_VALUE;
            } else {
                maxX = nums1[partitionX - 1];
            }

            if (partitionX == m) {
                minX = Integer.MAX_VALUE;
            } else {
                minX = nums1[partitionX];
            }

            if (partitionY == 0) {
                maxY = Integer.MIN_VALUE;
            } else {
                maxY = nums2[partitionY - 1];
            }

            if (partitionY == n) {
                minY = Integer.MAX_VALUE;
            } else {
                minY = nums2[partitionY];
            }
            
            if (maxX <= minY && maxY <= minX) {
                // Found the correct partition point
                if (totalLen % 2 == 0) {
                    // If total length is even, return average of the two middle elements
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    // If total length is odd, return the larger of the two middle elements
                    return (double) Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Move partition to the left in nums1
                right = partitionX - 1;
            } else {
                // Move partition to the right in nums1
                left = partitionX + 1;
            }
        }
        
        // If we reach here, input arrays are not sorted
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
