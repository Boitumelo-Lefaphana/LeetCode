class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0; // To store the total sum of absolute values
        int negativeCount = 0; // To count the negative numbers
        int minAbsValue = Integer.MAX_VALUE; // To track the smallest absolute value

        // Iterate through the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value); // Add absolute value to the total sum
                
                // Check if the value is negative
                if (value < 0) {
                    negativeCount++;
                }

                // Update the smallest absolute value
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        // If the count of negatives is odd, subtract twice the smallest absolute value
        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsValue;
        }

        return totalSum;
    }
}
