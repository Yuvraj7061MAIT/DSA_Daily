import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, permutation, used, result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                permutation.add(nums[i]);
                used[i] = true;
                backtrack(nums, permutation, used, result);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
