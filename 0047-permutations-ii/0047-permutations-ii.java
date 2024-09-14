import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array to handle duplicates
        boolean[] visited = new boolean[nums.length];  // To track used elements
        backtrack(nums, new ArrayList<>(), result, visited);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));  // Add a copy of the current permutation
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Step 2: Skip duplicates and already visited elements
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            
            visited[i] = true;  // Mark current element as used
            current.add(nums[i]);
            
            backtrack(nums, current, result, visited);
            
            // Backtrack by unmarking the element and removing it from the current permutation
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
