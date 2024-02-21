import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findSubset(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void findSubset(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) // Skip duplicates
                continue;
            
            subset.add(nums[i]);
            findSubset(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
