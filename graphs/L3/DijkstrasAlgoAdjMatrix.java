package graphs.L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasAlgoAdjMatrix {

    //calculates shortest weighted path from source to every other node in undirected graph



    public static int minIndex(int[] distance, boolean[] finalSet,int V){
        int minIndex=-1,min=Integer.MAX_VALUE;
        for(int i=0;i<V;i++){
            if(!finalSet[i]&&distance[i]<min){
                min=distance[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public static int[] dijkstraForAdjacencyMatrix(int V, int[][] adj,
                                                 int src){
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        boolean[] finalSet=new boolean[V];
        for(int i=0;i<V-1;i++){
            int minIndex=minIndex(distance,finalSet,V);
            finalSet[minIndex]=true;
            for(int j=0;j<V;j++){
                if(!finalSet[j]&&adj[minIndex][j]!=0&&distance[minIndex]!=Integer.MAX_VALUE&&distance[j]>distance[minIndex]+adj[minIndex][j]){
                    distance[j]=distance[minIndex]+adj[minIndex][j];
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {

        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        int[] distance = dijkstraForAdjacencyMatrix(graph.length, graph, 0);
        // Printing the Output
        System.out.println("Vertex  "
                + "  Distance from Source");
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + "             "
                    + distance[i]);
        }

    }
}
