class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Initialize maxProd, minProd, and the result with the first element
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        
        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            // When we encounter a negative number, max and min swap
            if (current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            
            // Calculate maxProd and minProd for the current element
            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);
            
            // Update the result with the maximum product found so far
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
}
