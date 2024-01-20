import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Calculate the next smaller element on the left for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate the next smaller element on the right for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0; // Change the type to long

        // Calculate the sum of minimums for each subarray
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - left[i]) * (right[i] - i) % 1000000007) % 1000000007;
        }

        return (int) result; // Cast the result back to int for the method signature
    }
}
