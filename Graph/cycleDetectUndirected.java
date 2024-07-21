package Graph;
import java.util.*;
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, int par, boolean[] vis){
        vis[curr] = true;
        
        for(int i=0; i<adj.get(curr).size();i++){
            int nextDest = adj.get(curr).get(i);
            if(!vis[nextDest]){
                if(dfs(adj, nextDest, curr, vis)){
                    return true;
                }
            }
            else if(vis[nextDest] == true && nextDest!=par){
                return true;
            }
        }
            
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V]; 
        for(int i=0; i< adj.size(); i++){
            if(!vis[i]){
                if(dfs(adj, i, -1, vis)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
}