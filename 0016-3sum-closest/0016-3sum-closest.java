import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize closest sum
        
        for (int i = 0; i < nums.length - 2; i++) {  // Step 2: Iterate through the array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {  // Step 3: Use two-pointer technique
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If the current sum is closer to target, update closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Step 4: Move pointers
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {  // If currentSum equals target, we've found the closest sum
                    return currentSum;
                }
            }
        }
        
        return closestSum;  // Return the closest sum found
    }
}
