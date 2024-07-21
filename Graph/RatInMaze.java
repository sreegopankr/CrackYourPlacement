package Graph;

import java.util.*;
class Solution {
    public void dfs(int[][] matrix, int i, int j, ArrayList<String> list, String str, boolean[][] vis){
        if(i<0 || j<0 || i>= matrix.length || j>= matrix[0].length){//boundary check
            return;
        }
        if(matrix[i][j] == 0 || vis[i][j]) return;//valid path check
        
        if(i==matrix.length-1 && j == matrix[0].length-1){
            list.add(str);
            return;
        }
        
        vis[i][j] = true;

        dfs(matrix,i+1,j,list,str+"D", vis);
        dfs(matrix,i,j+1,list,str+"R", vis);
        dfs(matrix,i-1,j,list,str+"U", vis);
        dfs(matrix,i,j-1,list,str+"L", vis);

        vis[i][j] = false; //backtrack
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        dfs(mat, 0, 0, list, "", vis);
        return list;
    }
}
