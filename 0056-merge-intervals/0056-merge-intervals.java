import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // Check if the current interval overlaps with the previous one
            if (currentInterval[1] >= intervals[i][0]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Add non-overlapping interval
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }
}
