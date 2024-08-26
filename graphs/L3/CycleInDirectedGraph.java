package graphs.L3;

import java.util.ArrayList;

import static graphs.L1.DFS.addEdge;

public class CycleInDirectedGraph {

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

//        addEdge(adj, 0, 1);
//        addEdge(adj, 1, 4);
        addEdge(adj,0, 1);
        addEdge(adj,0, 2);
        addEdge(adj,1, 2);
        addEdge(adj,2, 0);
        addEdge(adj,2, 3);
        addEdge(adj,3, 3);
        System.out.println(isCyclic(v,adj));
    }
    public static boolean dfsUtil(int V, ArrayList<ArrayList<Integer>> adj, int source, boolean[] recStack, boolean[] visited) {
        visited[source]=true;
        recStack[source]=true;
        for(int tmp:adj.get(source)){
            if(!visited[tmp]) {
                if (dfsUtil(V, adj, tmp, recStack, visited)) {
                    return true;
                }
            }else if (recStack[tmp]) {
                    return true;
                }
        }
        recStack[source]=false;
        return false;
    }
        private static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited=new boolean[V];
        boolean[] recStack=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfsUtil(V,adj,i,recStack,visited)){
                    return true;
                }
            }
        }
        return false;

    }
}
