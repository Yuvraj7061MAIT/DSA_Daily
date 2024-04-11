import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length; // Number of intervals
        
        // Sort the intervals based on start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < n; i++) {
            // Check if the current interval overlaps with the previous one
            if (currentInterval[1] >= intervals[i][0]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Add non-overlapping interval
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        // Convert List to array
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
