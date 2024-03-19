import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26]; 
        
        
        for (int i = 0; i < tasks.length; i++) {
            char task = tasks[i];
            int index = task - 'A';
            frequencies[index] = frequencies[index] + 1;
        }
        
        
        Arrays.sort(frequencies);
        
        int maxFrequency = frequencies[25]; // Maximum frequency of a task
        int idleTime = (maxFrequency - 1) * n; // Calculate idle time
        
        // Iterate through the frequencies array to count additional idle slots
        for (int i = frequencies.length - 2; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(frequencies[i], maxFrequency - 1);
        }
        
        idleTime = Math.max(0, idleTime); // Ensure idle time is non-negative
        
        return tasks.length + idleTime; // Total number of intervals needed
    }
}

