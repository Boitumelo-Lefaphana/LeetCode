class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretCount = new int[10]; // Frequency of digits in secret
        int[] guessCount = new int[10]; // Frequency of digits in guess

        // Step 1: Count bulls and record unmatched digits
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++; // Match found at the same position
            } else {
                // Record unmatched digits for later cow computation
                secretCount[s - '0']++;
                guessCount[g - '0']++;
            }
        }

        // Step 2: Count cows
        for (int i = 0; i < 10; i++) {
            // Cows are the minimum of unmatched counts for each digit
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        // Step 3: Return the result in the format "xAyB"
        return bulls + "A" + cows + "B";
    }
}
