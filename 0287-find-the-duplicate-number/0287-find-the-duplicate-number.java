import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int num : nums) {
            if (maps.containsKey(num)) {
                return num;
            } else {
                maps.put(num, 1);
            }
        }

        return -1;
    }
}
