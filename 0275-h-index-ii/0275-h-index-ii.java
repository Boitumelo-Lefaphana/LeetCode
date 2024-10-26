class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        int hIndex = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (citations[mid] >= n - mid) {
                hIndex = n - mid;  // Update hIndex to the current valid h
                right = mid - 1;   // Search in the left half for a larger possible h
            } else {
                left = mid + 1;    // Search in the right half
            }
        }
        
        return hIndex;
    }
}
