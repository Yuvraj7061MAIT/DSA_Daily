import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        
        // Fill the nums list with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            factorial[i] = factorial[i - 1] * i;
        }
        
        StringBuilder sb = new StringBuilder();
        k--; // Convert k to 0-based index
        
        // Iterate through each digit in the permutation
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n - i];
        }
        
        return sb.toString();
    }
}
