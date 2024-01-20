import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element using a normal for loop
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            Integer count = frequencyMap.get(num);
            if (count == null) {
                frequencyMap.put(num, 1);
            } else {
                frequencyMap.put(num, count + 1);
            }
        }

        List<Integer> majorityElements = new ArrayList<>();

        // Find the majority elements using a normal loop
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                majorityElements.add(entry.getKey());
            }
        }

        return majorityElements;
    }
}
