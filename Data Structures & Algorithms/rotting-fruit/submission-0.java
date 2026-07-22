class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int freshOranges = 0;
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if(x >= 0 && x < R && y >= 0 && y < C && grid[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 2;
                        freshOranges--;
                    }
                }
            }
            if(!queue.isEmpty()) {
                minutes++; 
            }          
        }
        return freshOranges > 0 ? -1 : minutes;
    }
}
