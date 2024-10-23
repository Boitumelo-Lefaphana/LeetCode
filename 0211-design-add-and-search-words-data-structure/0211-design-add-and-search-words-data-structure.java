class WordDictionary {

    // Define a TrieNode class for the Trie structure
    class TrieNode {
        TrieNode[] children;  // Array to store 26 possible letters
        boolean isWord;       // Flag to indicate the end of a word
        
        public TrieNode() {
            children = new TrieNode[26];  // For letters 'a' to 'z'
            isWord = false;
        }
    }

    private TrieNode root;  // Root node of the Trie

    public WordDictionary() {
        root = new TrieNode();  // Initialize the root node
    }

    // Method to add a word to the Trie
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';  // Map character to index (0-25)
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();  // Create a new node if not present
            }
            node = node.children[index];  // Move to the next node
        }
        node.isWord = true;  // Mark the end of the word
    }

    // Method to search for a word or pattern in the Trie
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    // Helper function to search in a specific TrieNode
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // If the character is '.', check all possible children
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null && searchInNode(word.substring(i + 1), node.children[j])) {
                        return true;
                    }
                }
                return false;  // No matching children found
            } else {
                // Normal character case
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;  // If the character does not exist, return false
                }
                node = node.children[index];  // Move to the next node
            }
        }
        return node.isWord;  // Return true if it's a valid word
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
