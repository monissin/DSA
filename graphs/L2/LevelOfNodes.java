package graphs.L2;

import java.util.ArrayList;

import static graphs.L1.DFS.addEdge;

public class LevelOfNodes {

    static int distance=-1;
    static void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int X,int dist,int source){
        visited[source]=true;
        if(source==X){
            distance=dist;
        }
        for(int i=0;i<adj.get(source).size();i++){
            if(!visited[adj.get(source).get(i)]){
                dfsUtil(adj,visited,X,dist+1,adj.get(source).get(i));
            }
        }
    }
    static int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        boolean[] visited=new boolean[V+1];
         dfsUtil(adj,visited,X,0,0);
         return distance;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj
                = new ArrayList<ArrayList<Integer> >(V+1);

        for (int i = 0; i < V+1; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 5);
        System.out.println(nodeLevel(6, adj,4));

    }
}
