class Solution {
    public boolean check(char[][] board, int i, int j) {
        if (i > 0 && board[i - 1][j] == 'X') return false; 
        if (j > 0 && board[i][j - 1] == 'X') return false; 
        return true;
    }
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && check(board, i, j)) count++;
            }
        }
        return count;
    }
}