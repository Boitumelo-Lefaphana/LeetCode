class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroPos = 0;

        // Move all non-zero elements to the beginning
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroPos] = nums[i];
                nonZeroPos++;
            }
        }

        // Fill the rest of the array with zeros
        for (int i = nonZeroPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
