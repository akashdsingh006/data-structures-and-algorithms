class Solution {
    int [] dx = {0,0,-1,1}, dy = {1,-1,0,0};
    static class Pair{
        int row,col;
        public Pair(int row, int col){
            this.row = row;this.col = col;
        }
    }
    public int[][] updateMatrix(int[][] grid) {
        int [][] dist = new int[grid.length][grid[0].length];
        for(int [] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }


         Queue<Pair> pendingQueue = new LinkedList<>();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    pendingQueue.add(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!pendingQueue.isEmpty()){
            Pair pair = pendingQueue.poll();
            for(int k =0; k < dx.length; k++){
                int newRow = pair.row + dx[k];
                int newCol = pair.col + dy[k];
                if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) continue;
                if(dist[newRow][newCol] == Integer.MAX_VALUE){
                    dist[newRow][newCol] = 1 + dist[pair.row][pair.col];
                    pendingQueue.add(new Pair(newRow, newCol));
                }
            }
        }
        return dist;
    }
}
