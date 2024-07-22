package Graph;

import java.util.*;
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] inRecursion, boolean[] vis){
        vis[curr] = true;
        inRecursion[curr] = true;
        
        for(int i=0; i<adj.get(curr).size(); i++){
            int nextDest = adj.get(curr).get(i);
            if(!vis[nextDest]){
                if(dfs(adj, nextDest, inRecursion, vis)){
                    return true;
                }
                
            }else if(inRecursion[nextDest]){
                return true;
            }
            
        }
        inRecursion[curr] = false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i] && dfs(adj, i, inRecursion, vis)){
                return true;
            }
        }
        return false;
    }
}
