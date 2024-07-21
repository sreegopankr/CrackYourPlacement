package Graph;

import java.util.*;
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis,ArrayList<Integer> list){
        vis[curr] = true;
        list.add(curr);

        for(int i=0; i<adj.get(curr).size(); i++){
            int nextDest = adj.get(curr).get(i);
            if(!vis[nextDest]){
                dfs(adj, nextDest, vis, list);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(adj,0,vis, list);
        return list;
    }
}