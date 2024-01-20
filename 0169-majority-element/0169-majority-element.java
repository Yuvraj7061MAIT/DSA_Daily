import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        // Find the majority element
        for (HashMap.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        // The majority element always exists, so this line won't be reached.
        return -1;
    }
}
