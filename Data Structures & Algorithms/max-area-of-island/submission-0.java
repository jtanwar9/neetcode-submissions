class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int currArea = dfs(grid, visited, i, j);
                    maxArea = Math.max(currArea, maxArea);
                }              
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        if(!isValid(grid, x, y) || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        
        return 1 + dfs(grid, visited, x + 1, y)
                 + dfs(grid, visited, x - 1, y)
                 + dfs(grid, visited, x, y + 1)
                 + dfs(grid, visited, x, y - 1);
    }

    private boolean isValid(int[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if(x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
            return true;
        }
        return false;
    }
    
}
