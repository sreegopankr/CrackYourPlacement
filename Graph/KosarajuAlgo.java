package Graph;
import java.util.*;
class Solution
{
    public void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer> stack){
        vis[u] = true;
        
        for(int v: adj.get(u)){
            if(!vis[v]){
                dfs(v,adj,vis,stack);
            }
        }
        stack.push(u);
    }
    public void dfsOnReversed(int u, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        vis[u] = true;
        
        for(int v: adj.get(u)){
            if(!vis[v]){
                dfsOnReversed(v,adj,vis);
            }
        }
        
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        //step1 topo graph
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                dfs(i,adj,vis,stack);
            }
        }
        
        //step2 make a reverse graph
        ArrayList<ArrayList<Integer>> adjReversed = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            adjReversed.add(new ArrayList<>());
        }
        
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                adjReversed.get(v).add(u);
            }
        }
        
        int countSCC = 0;
        
        //step3 call dfs based on stack order
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(!vis[curr]){
                dfsOnReversed(curr, adjReversed, vis);
                countSCC++;
            }
        }
        return countSCC;
    }
}
