class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] vis = new boolean[rows][cols];

        for(int i = 0;i<cols;i++){
            dfs(0,i,board,vis);
            dfs(rows-1,i,board,vis);
        }
        for(int i = 0;i<rows;i++){
            dfs(i,0,board,vis);
            dfs(i,cols-1,board,vis);
        }
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(board[i][j] == 'O' && !vis[i][j]) board[i][j] = 'X';
            }
        }
    }
    public void dfs(int r,int c,char[][] grid,boolean[][] vis){
        if(r<0 || r>grid.length-1 || c<0 || c> grid[0].length-1 || vis[r][c] || grid[r][c] == 'X') return;
        vis[r][c] = true;
        grid[r][c] = 'O';

        for(int[] d : dir){
            dfs(r+d[0],c+d[1],grid,vis);
        }
    }
}
