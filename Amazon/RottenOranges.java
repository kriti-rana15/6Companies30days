class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    int a[] = {i, j};
                    queue.add(a);
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) return 0;

        // Directions for moving in the grid (left, up, right, down)
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                // Check all four directions
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] != 1) continue;
                    grid[newX][newY] = 2;
                    queue.add(new int[]{newX, newY});
                    freshOranges--;
                    rotted = true;
                }
            }
            if (rotted) minutes++;
        }
        return freshOranges > 0 ? -1 : minutes;
    }
}
