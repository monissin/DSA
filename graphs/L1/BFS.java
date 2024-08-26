package graphs.L1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res=new ArrayList<>();
        boolean[] visited=new boolean[V+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        while (!queue.isEmpty()){
            Integer tmp=queue.poll();
            res.add(tmp);
            for(int i=0;i<adj.get(tmp).size();i++){
                if(!visited[adj.get(tmp).get(i)]){
                    queue.add(adj.get(tmp).get(i));
                    visited[adj.get(tmp).get(i)]=true;
                }
            }

        }
        return res;
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
        addEdge(adj, 0, 3);
        addEdge(adj, 2, 4);


        System.out.println(bfsOfGraph(V,adj));
    }
}
