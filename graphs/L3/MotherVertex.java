package graphs.L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static graphs.L1.DFS.addEdge;

public class MotherVertex {

    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj)
    {
       boolean[] visited=new boolean[V];
       for (int i=0;i<V;i++){
           dfs(i,visited,adj);
           boolean isMotherVertex=true;
           for(boolean tmp:visited){
               if(!tmp){
                   Arrays.fill(visited,false);
                   isMotherVertex=false;
                   break;
               }
           }
           if(isMotherVertex){
               return i;
           }
       }
       return -1;
    }

    public static void dfs(int source, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[source]=true;
        for(int i:adj.get(source)){
            if (!visited[i]){
                dfs(i,visited,adj);
            }
        }
    }

    public static void main(String[] args) {
        int v = 3;
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
//        addEdge(adj,0, 2);
//        addEdge(adj,0, 3);
        addEdge(adj,2, 1);
        addEdge(adj,0, 1);
//        addEdge(adj,3, 4);
      //  addEdge(adj,3, 1);
        System.out.println(findMotherVertex(v,adj));

    }
}
