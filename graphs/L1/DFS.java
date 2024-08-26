package graphs.L1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,
                               int u, int v)
    {
        adj.get(u).add(v);
    }

    public static void dfsUtil(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int source) {
        visited[source]=true;
        System.out.print(source+" ");
        for (int i=0;i<adj.get(source).size();i++){
            if(!visited[adj.get(source).get(i)]) {
                dfsUtil(visited,adj,adj.get(source).get(i));
            }
        }
    }
    public static void dfs(int V, ArrayList<ArrayList<Integer>> adj, int source) {
        boolean[] visited=new boolean[V+1];
        dfsUtil(visited,adj,source);
    }

    public static void main(String[] args)
    {
        // Creating a graph with 6 vertices
        int V = 5;
        ArrayList<ArrayList<Integer>> adj
                = new ArrayList<ArrayList<Integer> >(V+1);

        for (int i = 0; i < V+1; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 3);


       dfs(V,adj,2);
    }
}
