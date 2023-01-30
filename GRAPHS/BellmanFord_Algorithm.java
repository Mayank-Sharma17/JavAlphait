package GRAPHS;
import java.util.*;

public class BellmanFord_Algorithm {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s; this.dest = d; this.wt = w;
        }
    }
    public static void CreateGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }

    public static void CreateGraph2(ArrayList<Edge> graph) { //only edge ke information store hoge no array-vertex 
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4)); // index based add nahe honge
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length]; // distance array to store shortest distance from src to all vertices
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        // O(V*E)
        //now perform Algorithm- O(V)
        for(int i=0; i<V-1; i++) { // outer loop runs V-1 times O(V)

            // find edge- O(E) time comp nested loop for finding edge
            for(int j=0; j<graph.length; j++) { // vertices
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k); // u, v, w

                    // relaxation
                    if(dist[e.src] != Integer.MAX_VALUE && dist[e.src]+e.wt < dist[e.dest]) {
                        dist[e.dest] = dist[e.src]+e.wt; // update the dist of v
                    }
                }
            }
        }

        // print shortest distances
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) { // short code
        int dist[] = new int[V]; // distance array to store shortest distance from src to all vertices
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V*E)
        //now perform Algorithm- O(V)
        for(int i=0; i<V-1; i++) { // outer loop runs V-1 times O(V)
            // find edge- O(E) time comp nested loop for finding edge
            for(int j=0; j<graph.size(); j++) { // vertices
                Edge e = graph.get(j); // u, v, w
                // relaxation
                if(dist[e.src] != Integer.MAX_VALUE && dist[e.src]+e.wt < dist[e.dest]) {
                    dist[e.dest] = dist[e.src]+e.wt; // update the dist of v
                }
            }
        }

        // print shortest distances
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        /*                 -1
                   > 1 <----------- 4<
                2 /  |              |
                 /   |              |
                0    |-4            | 4
                 \   |              |
                4 \  >              |
                   > 2 -----------> 3
                            2
        */  
        int V = 5;
        //@SuppressWarnings("unchecked")
        //ArrayList<Edge>[] graph = new ArrayList[V]; 
        ArrayList<Edge> graph = new ArrayList<>();   
        CreateGraph2(graph); 
        bellmanFord2(graph, 0, V);           
    }
}
