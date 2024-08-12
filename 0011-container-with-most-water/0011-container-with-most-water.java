class Solution {
    public int maxArea(int[] height) {
        int left = 0;  // Pointer at the beginning
        int right = height.length - 1;  // Pointer at the end
        int maxArea = 0;  // Variable to store the maximum area found
        
        // Iterate until the pointers meet
        while (left < right) {
            // Calculate the area formed by the lines at left and right pointers
            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;
            
            // Update maxArea if the current area is larger
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;  // Return the maximum area found
    }
}
