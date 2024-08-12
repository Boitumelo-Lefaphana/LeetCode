import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int left = 0, right = 0, res = 0;
        
        while (right < nums.length) {
            // Add the current number to the map and count it
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            
            // If we have more than k distinct integers, move the left pointer
            while (count.size() > k) {
                count.put(nums[left], count.get(nums[left]) - 1);
                if (count.get(nums[left]) == 0) {
                    count.remove(nums[left]);
                }
                left++;
            }
            
            // Count the subarrays ending at the current right pointer
            res += right - left + 1;
            right++;
        }
        
        return res;
    }
}
