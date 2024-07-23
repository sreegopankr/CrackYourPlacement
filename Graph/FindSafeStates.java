package Graph;
import java.util.*;

class Solution {
    public boolean dfs(int[][] adj, int curr, boolean[] inRecursion, boolean[] vis){
        vis[curr] = true;
        inRecursion[curr] = true;
        
        for(int i=0; i<adj[curr].length; i++){
            int nextDest = adj[curr][i];
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
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph, i, inRecursion, vis);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(inRecursion[i] == false){
                result.add(i);
            }
        }

        return result;
    }
}
