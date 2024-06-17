class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        int element = 0;
        
        // Find the candidate for the majority element
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        
        // Verify if the candidate is actually the majority element
        int count1 = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == element) {
                count1++;
            }
        }
        
        // Check if the count is greater than n/2
        if (count1 > (n / 2)) {
            return element;
        }
        
        return -1;
    }
}
