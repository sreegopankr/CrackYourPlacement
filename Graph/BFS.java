/* 
import java.util.*;

class BFS {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        q.add(0);
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                visited[curr] = true;
                list.add(curr);
                for(int i=0; i<adj.get(curr).size(); i++){
                    q.add(adj.get(curr).get(i));
                }
            }
        }
        return list;
    }
}
*/