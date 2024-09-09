class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }

        // Get the previous sequence
        String previous = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        int count = 1;
        for (int i = 1; i < previous.length(); i++) {
            // If the current character is the same as the previous one, increase the count
            if (previous.charAt(i) == previous.charAt(i - 1)) {
                count++;
            } else {
                // Append the count and the previous character to the result
                result.append(count).append(previous.charAt(i - 1));
                count = 1; // Reset the count for the new character
            }
        }
        // Append the last count and character
        result.append(count).append(previous.charAt(previous.length() - 1));

        return result.toString();
    }
}
