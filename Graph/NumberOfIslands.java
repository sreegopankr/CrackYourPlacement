package Graph;
import java.util.*;
class Solution {
    int m,n;
    int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}}; 
    public void bfs(int i, int j, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = '*';

        while(!q.isEmpty()){
            int[] it = q.remove();
            for(int dir[] : directions){
                int i_ = it[0] + dir[0];
                int j_  = it[1] + dir[1];
                if(i_ < 0 || j_ < 0 || i_ >= m || j_ >= n || grid[i_][j_] != '1'){
                    continue;
                }else{
                    q.add(new int[]{i_, j_});
                    grid[i_][j_] = '*';
                }
            }
        }
            
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islands = 0;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    bfs(i, j, grid);
                }
            }
        }
        return islands;
    }
}