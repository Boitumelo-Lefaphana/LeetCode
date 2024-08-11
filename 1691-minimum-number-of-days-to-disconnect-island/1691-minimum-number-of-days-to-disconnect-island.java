class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int minDays(int[][] grid) {
        if (isDisconnected(grid)) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Try removing each land cell and check if it disconnects the island
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisconnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1; // revert the change
                }
            }
        }
        
        // If no single cell removal can disconnect, it takes at least 2 days
        return 2;
    }
    
    // Helper function to check if the grid is disconnected
    private boolean isDisconnected(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (islandCount > 0) {
                        return true; // More than one island found
                    }
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        
        return islandCount != 1;
    }
    
    // DFS to explore the island
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        for (int[] dir : directions) {
            dfs(grid, visited, i + dir[0], j + dir[1]);
        }
    }
}
