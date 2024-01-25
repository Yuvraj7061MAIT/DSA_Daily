import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        int longest = 1;
        int count = 0;
        int last_small = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i]-1 == last_small){
                count+=1;
                last_small = nums[i];
            }
            else if(nums[i]  != last_small){
                count=1;
                last_small = nums[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
}