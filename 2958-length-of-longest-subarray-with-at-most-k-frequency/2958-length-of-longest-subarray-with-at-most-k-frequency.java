import java.util.HashMap;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int n = nums.length;
        int ans = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (i <= j && map.getOrDefault(nums[j], 0) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}
