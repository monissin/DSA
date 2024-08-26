package graphs.L1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFSForUnconnectedGraph {

    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
    }

    // This will count disconnected components as well

    public static int bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[V+1];
        int count=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                bfsOfGraph(V,adj,visited,i);
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj,boolean[] visited,int source) {
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        visited[source]=true;
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
