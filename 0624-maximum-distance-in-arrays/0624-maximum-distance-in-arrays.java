import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize with the first array's min and max values
        int min_val = arrays.get(0).get(0);
        int max_val = arrays.get(0).get(arrays.get(0).size() - 1);
        int max_distance = 0;
        
        // Iterate over the rest of the arrays
        for (int i = 1; i < arrays.size(); i++) {
            int curr_min = arrays.get(i).get(0);
            int curr_max = arrays.get(i).get(arrays.get(i).size() - 1);
            
            // Calculate the distance using the current min and previous max, and vice versa
            max_distance = Math.max(max_distance, Math.abs(curr_max - min_val));
            max_distance = Math.max(max_distance, Math.abs(max_val - curr_min));
            
            // Update the min and max values
            min_val = Math.min(min_val, curr_min);
            max_val = Math.max(max_val, curr_max);
        }
        
        return max_distance;
    }
}
