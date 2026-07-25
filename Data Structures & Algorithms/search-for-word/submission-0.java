class Solution {
    public boolean exist(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(backtrack(word, 0, i, j, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(String word, int index, int row, int col, char[][] board) {
        if(index == word.length()) {
            return true;
        }

        if(isValid(board, row, col) && word.charAt(index) == board[row][col]) {
            char tmp = board[row][col];
            board[row][col] = '#';
            boolean found = backtrack(word, index + 1, row + 1, col, board)
                    || backtrack(word, index + 1, row - 1, col, board)
                    || backtrack(word, index + 1, row, col + 1, board)
                    || backtrack(word, index + 1, row, col - 1, board);
            board[row][col] = tmp;  
            return found;      
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
