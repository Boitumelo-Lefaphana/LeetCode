import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        // Step 1: Sort the points based on the end of the intervals
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrowCount = 1; // We need at least one arrow
        int arrowPosition = points[0][1]; // Place the first arrow at the end of the first balloon
        
        // Step 2: Iterate through the sorted intervals
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPosition) {
                // If the start of the current balloon is after the arrowPosition
                arrowCount++; // We need a new arrow
                arrowPosition = points[i][1]; // Update arrow position to the end of the current balloon
            }
        }
        
        return arrowCount;
    }
}
