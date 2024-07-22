package Graph;
import java.util.*;

class Solution {
    int n;
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean isSafe(int i, int j){
        return (i>=0 && j>=0 && i<n && j<n);
    }

    public void dfs(int i, int j, int[][] grid){
        if(!isSafe(i,j) || grid[i][j] == 0 || grid[i][j] == 2) return;
        grid[i][j] = 2;
        for(int dir[]: direction){
            int i_ = i + dir[0];
            int j_ = j + dir[1];            
            dfs(i_, j_, grid);
        }
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        int change  = 0;
        boolean firstIsland = false;

        //mark all first island as 2 to identify it as visited
        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid);
                    firstIsland = true;
                    break;
                }
            }
            if(firstIsland) break;
        }

        Queue<int[]> q = new LinkedList<>();
        //add first island to queue

        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        //perform bfs on firstIsland 
        while(!q.isEmpty()){
            change++;
            int size = q.size();
            while(size-- >0){
                int[] it = q.remove();
                for(int[] dir: direction){
                    int i_ = it[0] + dir[0];
                    int j_ = it[1] + dir[1];

                    if(isSafe(i_,j_)){
                        if(grid[i_][j_] == 0){
                            grid[i_][j_] = 2;
                            q.add(new int[]{i_,j_});
                        }
                        if(grid[i_][j_] == 1){ //  secondIsland found;
                            return change-1;
                        }
                    }
                }
            }
        }

        return 0;
    }
}