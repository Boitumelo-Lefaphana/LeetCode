import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        
        // Initialize frequency map and the initial window
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Populate the frequency map for the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        // Function to calculate x-sum from the frequency map
        answer[0] = calculateXSum(freqMap, x);
        
        // Slide the window across nums
        for (int i = 1; i <= n - k; i++) {
            int outNum = nums[i - 1];
            int inNum = nums[i + k - 1];
            
            // Remove the element going out of the window
            freqMap.put(outNum, freqMap.get(outNum) - 1);
            if (freqMap.get(outNum) == 0) {
                freqMap.remove(outNum);
            }
            
            // Add the new element coming into the window
            freqMap.put(inNum, freqMap.getOrDefault(inNum, 0) + 1);
            
            // Calculate x-sum for the current window
            answer[i] = calculateXSum(freqMap, x);
        }
        
        return answer;
    }
    
    private int calculateXSum(Map<Integer, Integer> freqMap, int x) {
        // Create a list of elements sorted by frequency and then by value
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        // Sort primarily by frequency in descending order, then by value in descending order
        freqList.sort((a, b) -> {
            if (b[1] != a[1]) {
                return Integer.compare(b[1], a[1]); // Sort by frequency
            } else {
                return Integer.compare(b[0], a[0]); // Sort by value if frequencies are the same
            }
        });
        
        // Sum the top x elements
        int sum = 0;
        int count = 0;
        for (int[] pair : freqList) {
            int value = pair[0];
            int freq = pair[1];
            if (count < x) {
                sum += value * freq;
                count++;
            } else {
                break;
            }
        }
        
        return sum;
    }
}
