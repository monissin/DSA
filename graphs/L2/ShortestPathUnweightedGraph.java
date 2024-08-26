package graphs.L2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static graphs.L1.DFS.addEdge;

public class ShortestPathUnweightedGraph {

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                               int dest, int v, int pred[], int dist[]) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
            pred[i]=-1;
        }
        queue.add(src);
        dist[src]=0;
        visited[src]=true;
        while (!queue.isEmpty()){
            Integer tmp=queue.poll();
            for(int i=0;i<adj.get(tmp).size();i++){
                if(!visited[adj.get(tmp).get(i)]){
                    visited[adj.get(tmp).get(i)]=true;
                    pred[adj.get(tmp).get(i)]=tmp;
                    dist[adj.get(tmp).get(i)]=dist[tmp]+1;
                    queue.add(adj.get(tmp).get(i));
                    if(adj.get(tmp).get(i)==dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static void printShortestDistance(
            ArrayList<ArrayList<Integer>> adj,
            int s, int dest, int v) {
        int[] predecessor=new int[v];
        int[] dist=new int[v];
        if(!BFS(adj,s,dest,v,predecessor,dist)){
            System.out.println("Given source and destination" +
                    "are not connected");
            return;
        }
        LinkedList<Integer> path=new LinkedList<>();
        int crawl=dest;
        path.add(crawl);
        while (predecessor[crawl]!=-1){
            path.add(predecessor[crawl]);
            crawl=predecessor[crawl];
        }
        System.out.println("Shortest path length is: " + dist[dest]);
        for(int i=path.size()-1;i>=0;i--){
            System.out.print(path.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        int v = 8;

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0, dest = 7;
        printShortestDistance(adj, source, dest, v);
    }
}
