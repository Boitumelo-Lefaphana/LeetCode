import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store the first occurrence of each cumulative sum
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with sum 0 at index -1
        
        int maxLength = 0;
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1
            if (nums[i] == 0) {
                cumulativeSum -= 1;
            } else {
                cumulativeSum += 1;
            }
            
            // Check if this cumulative sum has been seen before
            if (map.containsKey(cumulativeSum)) {
                // Calculate the length of the subarray
                int previousIndex = map.get(cumulativeSum);
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                // Store the first occurrence of this cumulative sum
                map.put(cumulativeSum, i);
            }
        }
        
        return maxLength;
    }
}
