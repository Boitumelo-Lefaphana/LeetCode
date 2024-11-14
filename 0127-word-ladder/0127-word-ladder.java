import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int length = current.getValue();

            // Try all possible transformations by changing each character
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String transformedWord = new String(wordArray);

                    // Check if we've reached the endWord
                    if (transformedWord.equals(endWord)) {
                        return length + 1;
                    }

                    // If the transformed word is in the set, add it to the queue and remove it from the set
                    if (wordSet.contains(transformedWord)) {
                        queue.add(new Pair<>(transformedWord, length + 1));
                        wordSet.remove(transformedWord);
                    }
                }
            }
        }

        return 0;
    }
}
