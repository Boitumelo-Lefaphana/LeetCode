class Solution {
    public int jump(int[] nums) {
        // Number of jumps needed
        int jumps = 0;
        // Farthest point reachable with the current number of jumps
        int currentEnd = 0;
        // Farthest point reachable overall
        int farthest = 0;
        
        // Traverse the array except the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point reachable
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we have reached the end of the current jump range
            if (i == currentEnd) {
                // Increase the jump count
                jumps++;
                // Set the current end to the farthest point we can reach
                currentEnd = farthest;
                
                // If the farthest point reaches or exceeds the last index, break early
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
}
