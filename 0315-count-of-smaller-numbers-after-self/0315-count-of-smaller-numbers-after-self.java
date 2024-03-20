import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        // Step 1: Create a sorted set of the distinct numbers
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // Step 2: Map each number to its corresponding rank in the sorted set
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int num : set) {
            rankMap.put(num, ++rank);
        }
        
        // Step 3: Create a Binary Indexed Tree (BIT) to store the counts
        int[] bit = new int[rankMap.size() + 1];
        
        // Step 4: Traverse the numbers in reverse order and count smaller elements using BIT
        for (int i = nums.length - 1; i >= 0; i--) {
            int rankIndex = rankMap.get(nums[i]);
            result.add(0, query(bit, rankIndex - 1)); // Get count of smaller elements
            update(bit, rankIndex); // Update BIT for the current element
        }
        
        return result;
    }
    
    // Update the BIT to mark the presence of an element at the given index
    private void update(int[] bit, int index) {
        while (index < bit.length) {
            bit[index]++;
            index += index & -index;
        }
    }
    
    // Query the BIT to get the count of elements with index less than the given index
    private int query(int[] bit, int index) {
        int count = 0;
        while (index > 0) {
            count += bit[index];
            index -= index & -index;
        }
        return count;
    }
}
