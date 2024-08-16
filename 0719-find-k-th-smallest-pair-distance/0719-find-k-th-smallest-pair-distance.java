import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) >= k) {
                high = mid;  // We need a smaller distance
            } else {
                low = mid + 1;  // We need a larger distance
            }
        }
        
        return low;
    }
    
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }
}
