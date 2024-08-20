import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        // Iterate through all possible hour and minute values
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // Count the number of 1's in the binary representation of hour and minute
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    // Format the time and add to the result
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        
        return result;
    }
}
