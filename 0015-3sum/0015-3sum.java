import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Add the triplet to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move the left and right pointers to avoid duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    // If the sum is less than 0, move the left pointer to the right
                    left++;
                } else {
                    // If the sum is greater than 0, move the right pointer to the left
                    right--;
                }
            }
        }
        
        return result;
    }
}
