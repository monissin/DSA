package graphs.L3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static graphs.L1.DFS.addEdge;

public class TopologicalSorting {

    /**
     * A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
     * Proof: There’s a simple proof to the above fact that a DAG does not contain a cycle which means that all paths will be of finite length. Now let S be the longest path from u(source) to v(destination). Since S is the longest path there can be no incoming edge to u and no outgoing edge from v, if this situation had occurred then S would not have been the longest path
     * => indegree(u) = 0 and outdegree(v) = 0
     */

    // Time Complexity: O(V+E).
    // Auxiliary Space: O(V).
    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v){
        int[] inDegree =new int[v];
        for(int i=0;i<v;i++){
            for(int tmp:adj.get(i)){
                inDegree[tmp]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        ArrayList<Integer> order=new ArrayList<>();
        int count=0;
        while (!queue.isEmpty()){
            int tmp= queue.poll();
            order.add(tmp);
            for(int j:adj.get(tmp)){
                if(--inDegree[j]==0){
                    queue.add(j);
                }
            }
            count++;
        }
        if(count!=v){
            System.out.println(
                    "There exists a cycle in the graph");
            return;
        }
        for (int i : order) {
            System.out.print(i + " ");
        }
    }


    public static void dfs(int source, boolean[] visited, Stack<Integer> stk,ArrayList<ArrayList<Integer>> adj){
        visited[source]=true;
        for(int i:adj.get(source)){
            if (!visited[i]){
                dfs(i,visited,stk,adj);
            }
        }
        stk.push(source);

    }
    public static void topologicalSortDfs(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] visited =new boolean[v];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,stk,adj);
            }
        }
        while (!stk.isEmpty()) {
                System.out.print(stk.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,5, 2);
        addEdge(adj,5, 0);
        addEdge(adj,4, 0);
        addEdge(adj,4, 1);
        addEdge(adj,2, 3);
        addEdge(adj,3, 1);
        topologicalSort(adj,v);
        System.out.println();
        topologicalSortDfs(adj,v);

    }


}
