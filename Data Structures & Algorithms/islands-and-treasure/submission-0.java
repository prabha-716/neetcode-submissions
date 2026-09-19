class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[] {r, c});
                }
            }
        }
        bfs(q, grid);
    }
    public void bfs(Queue<int[]> q, int[][] grid) {
        if(q.isEmpty()) return;
        int rows = grid.length;
        int cols = grid[0].length;
        int level = 1;
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0;i<s;i++){
                int[] cur = q.poll();
                for(int[] d : dir){
                    int nr = d[0]+cur[0];
                    int nc = d[1]+cur[1];
                    if(nr<rows && nc<cols && nr>=0 && nc>=0 && grid[nr][nc]==Integer.MAX_VALUE){
                        grid[nr][nc] = level;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            level++;
        }
    }
}
