import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Array to count frequency of each task
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }
        
        // Find the maximum frequency of any task
        int maxFreq = 0;
        for (int count : taskCounts) {
            maxFreq = Math.max(maxFreq, count);
        }
        
        // Count how many tasks have the max frequency
        int maxCount = 0;
        for (int count : taskCounts) {
            if (count == maxFreq) {
                maxCount++;
            }
        }
        
        // Calculate the minimum intervals needed
        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}
