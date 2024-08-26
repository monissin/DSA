package graphs.L2;

import java.util.ArrayList;

import static graphs.L1.DFS.addEdge;

public class CycleInUndirectedGraph {

    public static boolean dfsUtil(int V, ArrayList<ArrayList<Integer>> adj, int source, int parent, boolean[] visited){
        visited[source]=true;
        for(int i=0;i<adj.get(source).size();i++){
            if(!visited[adj.get(source).get(i)]){
                if(dfsUtil(V,adj,adj.get(source).get(i),source,visited)){
                    return true;
                }
            } else if (adj.get(source).get(i)!=parent){
                return true;
            }
        }
        return false;
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfsUtil(V,adj,i,-1,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

//        addEdge(adj, 0, 1);
//        addEdge(adj, 1, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
//        addEdge(adj, 3, 4);
        System.out.println(isCycle(v,adj));

    }
}
