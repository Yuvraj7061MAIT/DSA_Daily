import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task using a HashMap
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char task : tasks) {
            frequencyMap.put(task, frequencyMap.getOrDefault(task, 0) + 1);
        }
        
        // Step 2: Push tasks and their frequencies into a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(frequencyMap.values());
        
        // Step 3: Initialize variables
        int cycles = 0;
        
        // Step 4: Process tasks while the priority queue is not empty
        while (!maxHeap.isEmpty()) {
            int interval = n + 1;
            // Initialize a temporary list to hold tasks for the current cycle
            var temp = new PriorityQueue<Integer>((a, b) -> b - a);
            // Process tasks for the current cycle
            while (interval > 0 && !maxHeap.isEmpty()) {
                // Pop a task from the max heap
                int frequency = maxHeap.poll();
                // Decrement frequency and add to the temporary list if frequency is greater than 1
                if (frequency > 1) {
                    temp.offer(frequency - 1);
                }
                // Decrement the interval
                interval--;
                // Increment the cycle count
                cycles++;
            }
            // Push back tasks from the temporary list into the max heap
            maxHeap.addAll(temp);
            // Check if there are any remaining tasks to process, if so, add idle cycles
            if (!maxHeap.isEmpty()) {
                cycles += interval;
            }
        }
        
        // Step 5: Return the total number of cycles
        return cycles;
    }
}
