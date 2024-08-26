package graphs.L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class ShortestPathInDAG {
    //DAG : Directed Acyclic Graph
    //Time complexity = O(V+E)

    public static Stack<Integer> topologicalSortDfs(ArrayList<ArrayList<DijkstrasAlgoAdjList.AdjListNode>> adj, int v){
        boolean[] visited =new boolean[v];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,stk,adj);
            }
        }
        return stk;
    }

    public static void dfs(int source, boolean[] visited, Stack<Integer> stk,ArrayList<ArrayList<DijkstrasAlgoAdjList.AdjListNode>> adj){
        visited[source]=true;
        for(DijkstrasAlgoAdjList.AdjListNode i:adj.get(source)){
            if (!visited[i.getVertex()]){
                dfs(i.getVertex(),visited,stk,adj);
            }
        }
        stk.push(source);

    }

    public static int[] shortestPathDAG(int V, ArrayList<ArrayList<DijkstrasAlgoAdjList.AdjListNode>> adj,
                                                 int src) {
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        Stack<Integer> stk=topologicalSortDfs(adj,V);
        while (!stk.isEmpty()){
            Integer tmp=stk.pop();
            for(DijkstrasAlgoAdjList.AdjListNode node:adj.get(tmp)){
                if(distance[tmp]!=Integer.MAX_VALUE&&distance[node.getVertex()]>distance[tmp]+node.getWeight()){
                    distance[node.getVertex()]=distance[tmp]+node.getWeight();
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<DijkstrasAlgoAdjList.AdjListNode>> adj =
                new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1,1);
        addEdge(adj,1,2,3);
        addEdge(adj,1,3,2);
        addEdge(adj,2,3,4);
        int[] distance=shortestPathDAG(v,adj,1);
        System.out.println("Vertex  "
                + "  Distance from Source");
        for (int i = 0; i < v; i++) {
            System.out.println(i + "             "
                    + distance[i]);
        }
    }

    public static void addEdge(ArrayList<ArrayList<DijkstrasAlgoAdjList.AdjListNode>> adj,
                               int u, int v,int weight)
    {
        adj.get(u).add(new DijkstrasAlgoAdjList.AdjListNode(v,weight));
    }
}
