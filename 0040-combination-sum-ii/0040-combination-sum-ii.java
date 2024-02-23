import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void combinationSum(int[] candidates, int remaining, int start, List<Integer> combination, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) // Skip duplicates
                continue;
            
            if (candidates[i] > remaining) // Skip if current candidate is greater than remaining
                break;
            
            combination.add(candidates[i]);
            combinationSum(candidates, remaining - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
