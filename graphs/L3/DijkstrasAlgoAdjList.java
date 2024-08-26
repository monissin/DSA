package graphs.L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasAlgoAdjList {

    //calculates shortest weighted path from source to every other node in undirected graph
    //Note: The Dijkstra's Algorithm doesn't work in the case when the Graph has negative edge weight.

    static class AdjListNode {
        int vertex, weight;

        AdjListNode(int v, int w)
        {
            vertex = v;
            weight = w;
        }
        int getVertex() { return vertex; }
        int getWeight() { return weight; }
    }


    /***
     * If we take a closer look, we can observe that the statements in the inner loop are executed O(V+E) times (similar to BFS).
     * The inner loop has decreaseKey() operation which takes O(LogV) time.
     * So overall time complexity is O(E+V)*O(LogV) which is O((E+V)*LogV) = O(ELogV)
     */

    public static int[] dijkstraForAdjacencyList(int V, ArrayList<ArrayList<AdjListNode>> adj,
                                                 int src){
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        PriorityQueue<AdjListNode> priorityQueue=new PriorityQueue<>(
                Comparator.comparingInt(AdjListNode::getWeight)
        );
        priorityQueue.add(new AdjListNode(src,0));
        while (!priorityQueue.isEmpty()){
            AdjListNode node=priorityQueue.poll();
            for(AdjListNode tmp:adj.get(node.getVertex())){
                if(distance[tmp.getVertex()]>distance[node.getVertex()]+tmp.getWeight()){
                    distance[tmp.getVertex()]=distance[node.getVertex()]+tmp.getWeight();
                    priorityQueue.add(new AdjListNode(tmp.getVertex(), distance[tmp.getVertex()]));
                }
            }
        }
        return distance;

    }
    public static void main(String[] args) {

        int V = 9;
        ArrayList<ArrayList<AdjListNode> > graph
                = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new AdjListNode(1, 4));
        graph.get(0).add(new AdjListNode(7, 8));
        graph.get(1).add(new AdjListNode(2, 8));
        graph.get(1).add(new AdjListNode(7, 11));
        graph.get(1).add(new AdjListNode(0, 7));
        graph.get(2).add(new AdjListNode(1, 8));
        graph.get(2).add(new AdjListNode(3, 7));
        graph.get(2).add(new AdjListNode(8, 2));
        graph.get(2).add(new AdjListNode(5, 4));
        graph.get(3).add(new AdjListNode(2, 7));
        graph.get(3).add(new AdjListNode(4, 9));
        graph.get(3).add(new AdjListNode(5, 14));
        graph.get(4).add(new AdjListNode(3, 9));
        graph.get(4).add(new AdjListNode(5, 10));
        graph.get(5).add(new AdjListNode(4, 10));
        graph.get(5).add(new AdjListNode(6, 2));
        graph.get(6).add(new AdjListNode(5, 2));
        graph.get(6).add(new AdjListNode(7, 1));
        graph.get(6).add(new AdjListNode(8, 6));
        graph.get(7).add(new AdjListNode(0, 8));
        graph.get(7).add(new AdjListNode(1, 11));
        graph.get(7).add(new AdjListNode(6, 1));
        graph.get(7).add(new AdjListNode(8, 7));
        graph.get(8).add(new AdjListNode(2, 2));
        graph.get(8).add(new AdjListNode(6, 6));
        graph.get(8).add(new AdjListNode(7, 1));

        int[] distance = dijkstraForAdjacencyList(V, graph, source);
        // Printing the Output
        System.out.println("Vertex  "
                + "  Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "             "
                    + distance[i]);
        }

    }
}
