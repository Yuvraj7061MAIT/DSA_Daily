import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the break point
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist
        if (ind == -1) {
            // reverse the whole array
            reverseArray(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the next greater element and swap it with nums[ind]
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // Step 3: Reverse the right half
        reverseArray(nums, ind + 1, n - 1);
    }

    // Helper function to reverse a portion of the array
    private void reverseArray(int[] arr, int start, int end) {
        List<Integer> sublist = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            sublist.add(arr[i]);
        }
        Collections.reverse(sublist);
        for (int i = start; i <= end; i++) {
            arr[i] = sublist.get(i - start);
        }
    }

    // Helper function to swap elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
