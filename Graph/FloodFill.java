package Graph;
import java.util.*;
class Solution {
    public void bfs(int[][] image, int sr, int sc, int color, boolean[][] vis){
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int fill = image[sr][sc];
        image[sr][sc] = color;
        vis[sr][sc] = true;

        while(!q.isEmpty()){
            int[] it = q.remove();
            for(int[] dir : direction){
                int i_ = it[0] + dir[0];
                int j_ = it[1] + dir[1];
                if(i_<0 || j_<0 || i_>=image.length || j_>=image[0].length || image[i_][j_] != fill){
                    continue;
                }
                if(!vis[i_][j_]){
                    vis[i_][j_] = true;
                    image[i_][j_] = color;
                    q.add(new int[]{i_, j_});  
                }
                
            }
        } 
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        bfs(image, sr, sc, color, vis);
        return image;
    }
}