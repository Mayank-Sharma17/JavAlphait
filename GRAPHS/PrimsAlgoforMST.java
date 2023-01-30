package GRAPHS;
import java.util.*;

public class PrimsAlgoforMST {
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

        graph[0].add(new Edge(0, 1, 10)); 
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10)); 
        graph[1].add(new Edge(1, 3, 40));  
        graph[2].add(new Edge(2, 0, 15)); 
        graph[2].add(new Edge(2, 3, 50)); 
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40)); 
        graph[3].add(new Edge(3, 2, 50));    
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.cost-p2.cost; // cost based sorting
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // pairs ke object pq mae store honge
        
        pq.add(new Pair(0, 0)); // initilize with 0-0 pair
        int finalcost = 0; // MST total min cost isee ham ArrayList<Edge> mae bhe return krskte

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) { // current vertex
                vis[curr.v] = true;
                finalcost += curr.cost;

                //neighbour
                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt)); // v, cost
                }
            }
        }
        System.out.println("final min cost of MST = "+finalcost);
    }
    public static void main(String[] args) {
        /*  
                   0
               10/ | \15
                /  |  \
               1   |30 2    min cost = 55
                \  |  /
               40\ | /50
                   3
        */
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
