package GRAPHS;
import java.util.*;

public class CreateGraph {
    static class Edge { // it contains properties of edge
        int src; // source
        int dest; // destination
        int wt; // weight properties
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void main(String[] args) {
            //     (5)
            // 0 ------ 1
            //         / \
            //     (1)/   \(3)
            //       /     \
            //      2 ----- 3
            //      |  (1)
            //   (2)|
            //      |
            //      4

        int V = 5; // there are 5 Vertex in graph
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V]; // null-> empty ArrayList
        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        //0-vertex
        graph[0].add(new Edge(0, 1, 5));

        //1-veretex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        //3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //4-vertex
        graph[4].add(new Edge(1, 3, 3));

        // 2's neighbours
        for(int i=0; i<graph[2].size(); i++) {
            Edge e = graph[2].get(i); // AL ke ander Edge hai- src, dest, wt
            System.out.println(e.dest); // 1 3 4
        }
    }
}