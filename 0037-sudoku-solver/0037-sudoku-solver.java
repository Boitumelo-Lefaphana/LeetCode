class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        // Traverse the entire board to find an empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If the current cell is empty
                if (board[i][j] == '.') {
                    // Try placing digits 1-9 in the empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;  // Place the number
                            if (solve(board)) {  // Recur to the next empty cell
                                return true;
                            }
                            board[i][j] = '.';  // Backtrack if no solution found
                        }
                    }
                    return false;  // If no valid number can be placed, backtrack
                }
            }
        }
        return true;  // All cells are filled, puzzle solved
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        
        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // Check the 3x3 sub-grid
        int subGridRow = (row / 3) * 3;
        int subGridCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subGridRow + i][subGridCol + j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
