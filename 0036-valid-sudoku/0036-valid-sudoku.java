class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create arrays of sets to track seen digits in rows, columns, and 3x3 boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        
        // Initialize the sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        // Iterate over each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                
                // Ignore empty cells
                if (num == '.') continue;
                
                // Calculate the box index
                int boxIndex = (i / 3) * 3 + (j / 3);
                
                // Check if the number already exists in the row, column or box
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                    return false; // Duplicate found, so the Sudoku board is invalid
                }
                
                // Add the number to the row, column, and box sets
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }
        
        // If no duplicates are found, the board is valid
        return true;
    }
}
