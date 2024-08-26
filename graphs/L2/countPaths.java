package graphs.L2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static graphs.L1.DFS.addEdge;

public class countPaths {

    public static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()){
            Integer tmp= queue.poll();
            if(tmp==destination){
                count++;
            }
            for(int i=0;i<adj.get(tmp).size();i++){
                    queue.add(adj.get(tmp).get(i));
            }
        }
        return count;
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
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 2);
        System.out.println(countPaths(V,adj,0,4));
    }
}
