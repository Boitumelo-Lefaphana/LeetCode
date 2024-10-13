import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    
    // Insert a word into the Trie
    private void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word; // Mark the end of the word
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        // Step 1: Build the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word);
        }
        
        // Step 2: Start backtracking for each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, root, result);
            }
        }
        
        return result;
    }
    
    private void backtrack(char[][] board, int row, int col, TrieNode node, List<String> result) {
        char letter = board[row][col];
        
        // Ensure the character is valid, skip if it's been visited (marked as '#')
        if (letter == '#' || letter < 'a' || letter > 'z') {
            return;
        }
        
        int index = letter - 'a';
        
        // Base Case: Return if the letter is not in the current TrieNode
        if (node.children[index] == null) {
            return;
        }
        
        node = node.children[index];
        
        // Check if we found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null;  // To avoid adding duplicate words
        }
        
        // Mark the cell as visited by setting it to a special character
        board[row][col] = '#';
        
        // Explore the 4 possible directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // Ensure the new cell is within bounds
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                backtrack(board, newRow, newCol, node, result);
            }
        }
        
        // Restore the cell to its original value
        board[row][col] = letter;
    }
}
