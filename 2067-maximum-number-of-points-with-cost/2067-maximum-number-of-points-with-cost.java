class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        
        // Initialize the dp array with the first row
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        
        // Iterate over each row starting from the second one
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            long[] newDp = new long[n];
            
            // Compute left to right max
            left[0] = dp[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1], dp[j] + j);
            }
            
            // Compute right to left max
            right[n - 1] = dp[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[j] - j);
            }
            
            // Calculate new dp values for the current row
            for (int j = 0; j < n; j++) {
                newDp[j] = points[i][j] + Math.max(left[j] - j, right[j] + j);
            }
            
            dp = newDp; // Move to the next row
        }
        
        // The answer is the maximum value in the last dp array
        long result = 0;
        for (long value : dp) {
            result = Math.max(result, value);
        }
        
        return result;
    }
}
