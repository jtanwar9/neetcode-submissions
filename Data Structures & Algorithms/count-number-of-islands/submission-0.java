class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        Set<String> visited = new HashSet<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == '1' && !visited.contains(i + "-" + j)) {
                    dfs(grid, visited, i, j);
                    count++;
                }              
            }
        }
        return count;
    }

    private void dfs(char[][] grid, Set<String> visited, int x, int y) {
        if(visited.contains(x + "-" + y) || !isValid(grid, x, y)) {
            return;
        }

        visited.add(x + "-" + y);
        
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
