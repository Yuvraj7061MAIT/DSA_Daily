public class Solution {
    private static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int cnt = 0;

        while (left <= mid && right <= high) {
            if ((long) arr[left] > 2 * (long) arr[right]) {
                cnt += mid - left + 1;  // Counting reverse pairs
                right++;
            } else {
                left++;
            }
        }

        left = low;
        right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= high) {
            temp[index++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return cnt;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            cnt += mergeSort(arr, low, mid);
            cnt += mergeSort(arr, mid + 1, high);
            cnt += merge(arr, low, mid, high);
        }
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
