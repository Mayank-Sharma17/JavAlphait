package GRAPHS;
import java.util.*;

public class DFStraversal {
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

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1)); 
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    // DFS for connected components------------------------------------------------------------
    public static void dfs(ArrayList<Edge>[] graph) { // one extra funxn for each part of graph T.C O(V+E)
        boolean vis[] = new boolean[graph.length]; // V size ka arr
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        } 
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) { // O(V+E ) curr-vertex number
        // visit-> keep going to the 1st neighbour
        System.out.print(curr+" "); // 0 1 3 4 2 5 6
        vis[curr] = true;

        for(int i=0; i< graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // list of edge
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis); // recursion (stack)
            }
        }
    }
    public static void main(String[] args) {
        /* 
                1 --- 3
                /      | \
                0      |  5 --- 6
                \      | /
                2 --- 4 
        */

        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph);
    }
}
