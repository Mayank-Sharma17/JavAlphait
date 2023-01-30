package GRAPHS;
import java.util.*;

public class Dijkstras_Algorithm { // Shortest parth from source to destination 
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class pair implements Comparable<pair> { // for comparing the distance of shortest path 
        int n; // n is node  ....greedy approach
        int path; // distance pair(node, dist)
        public pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(pair p2) {
            return this.path-p2.path; // path based sorting for our pairs
        }
    }

    public static void dijkstras(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length]; // dist[i] -> src to i
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>(); // using BFS approach
        pq.add(new pair(src, 0)); // initialize first pair (0, 0)

        while(!pq.isEmpty()) {
            pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                //neighbour
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u]+wt < dist[v]) { // update dist - src to v
                        dist[v] = dist[u]+wt;
                        pq.add(new pair(v, dist[v])); // add in queue new pair v ka banega or uska dist
                    }
                }
            }
        }
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        /*         
                    7
                >1 ---> 3
              2/ |     <| \1
              0  |1    2|  >>5 2 incoming edges points towards 5
              4\ |>     | /5   
                >2 ---> 4 
                    3
        */
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);
        int src = 0;
        dijkstras(graph, src);
    }
}
// time complexity of this algo is O(V+ElogV)
// ElogV is for priority Queue internal sorting of pairs
// V if for running a loop on visited or for desination
