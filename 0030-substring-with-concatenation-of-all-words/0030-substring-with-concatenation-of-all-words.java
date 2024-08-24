import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int numWords = words.length;
        int totalLength = wordLength * numWords;

        // Frequency map for words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Slide over the string with different starting points
        for (int i = 0; i < wordLength; i++) {
            int left = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();

            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                if (wordCount.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    // Adjust the window if we have too many of a particular word
                    while (seenWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    // If we found a valid substring
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Reset if the word is not in the list
                    seenWords.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }

        return result;
    }
}
