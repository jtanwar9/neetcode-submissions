class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }              
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        if(!isValid(grid, x, y) || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        
        dfs(grid, visited, x + 1, y);
        dfs(grid, visited, x - 1, y);
        dfs(grid, visited, x, y + 1);
        dfs(grid, visited, x, y - 1);
    }

    private boolean isValid(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if(x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
            return true;
        }
        return false;
    }
}
