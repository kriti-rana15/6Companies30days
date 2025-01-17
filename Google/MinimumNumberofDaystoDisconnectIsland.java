class Solution {
    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || visited[row][col]) return;

        visited[row][col] = true;
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
    private int noOfIslands(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    public int minDays(int[][] grid) {
        int count = noOfIslands(grid);
        if (count > 1) return 0;
        if (count == 0) return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0)continue;
                grid[i][j] = 0;
                if(noOfIslands(grid) != 1)return 1;
                grid[i][j] = 1;
            }
        }
        return 2;
    }
};