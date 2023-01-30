package GRAPHS;
import java.util.*;

public class CheapestFlightKstops {
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

    public static void createGraph(int flights[][], ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>(); //adjacency list
        }
        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt); //flights ke information ko graph mar add kr
            graph[src].add(e); // src he index banjaega |0|1| inn idx pr list of edge
        }
    }

    static class Info { // flights ke information
        int vertex;
        int cost;
        int stops;
        public Info(int v, int c, int s) {
            this.vertex = v;
            this.cost = c;
            this.stops = s;
        }
    }
    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        //create graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph); 

        //dijkstras modified
        int dist[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // src to src ko coast 0 or stop bhe 0 initialize
        while(!q.isEmpty()) {
            Info curr = q.remove();
            // conditions of stops k
            if(curr.stops > k) {
                break;
            }
            for(int i=0; i<graph[curr.vertex].size(); i++) { // neighbours of curr call
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                
                // relaxation
                if(curr.cost+wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        // dist of dest
        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }
    public static void main(String[] args) {
        int n = 4; // cities
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0; int dest = 3; int k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}