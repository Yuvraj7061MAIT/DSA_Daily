class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0; // Pointer to keep track of the position to place the next non-zero element
        int right = 0; // Pointer to iterate through the array
        
        while (right < nums.length) {
            // If the current element is non-zero, swap it with the element at position left
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; // Move the left pointer to the next position
            }
            right++; // Move the right pointer to the next position
        }
    }
}
