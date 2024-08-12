import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // A HashSet to store the unique characters in the current window
        HashSet<Character> set = new HashSet<>();
        
        int left = 0; // Left pointer of the window
        int maxLength = 0; // Variable to store the maximum length
        
        // Right pointer of the window iterates through the string
        for (int right = 0; right < s.length(); right++) {
            // If the character at right pointer is already in the set,
            // we need to shrink the window from the left to remove the duplicate
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add the character at right pointer to the set
            set.add(s.charAt(right));
            
            // Update the maximum length if the current window is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
