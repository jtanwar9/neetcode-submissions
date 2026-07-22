class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int count = 0;
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }              
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for(int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if(x >= 0 && x < R && y >= 0 && y < C && grid[x][y] == Integer.MAX_VALUE) {
                    queue.add(new int[]{x, y});
                    grid[x][y] = grid[row][col] + 1;
                }
            }
        }
    }
}
