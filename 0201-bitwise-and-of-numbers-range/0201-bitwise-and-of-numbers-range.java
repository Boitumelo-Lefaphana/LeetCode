class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Shift both left and right until they are equal
        int shiftCount = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }
        // Shift back to the left to recover the common prefix
        return left << shiftCount;
    }
}
