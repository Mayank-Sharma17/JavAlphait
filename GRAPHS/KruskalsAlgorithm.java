package GRAPHS;
import java.util.*;

public class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.wt-e2.wt; // sorting on the basis of weight
        }
    }

    static void createGraph(ArrayList<Edge> graph) {
        
        graph.add(new Edge(0, 1, 10)); 
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 0, 10)); 
        graph.add(new Edge(1, 3, 40));  
        graph.add(new Edge(2, 0, 15)); 
        graph.add(new Edge(2, 3, 50)); 
        graph.add(new Edge(3, 0, 30));
        graph.add(new Edge(3, 1, 40)); 
        graph.add(new Edge(3, 2, 50));    
    }

    static int n = 4; // vertices
    static int par[] = new int[n]; // parent array
    static int rank[] = new int[n]; // rank array height

    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i; // initialize parrent
        }
    }

    public static int find(int x) { // leader
        if(x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]); // path compression time complexity decrease
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            //kise ko bhe kiseka parrent bana skte hai
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void krushkalMST(ArrayList<Edge> edges, int V) {
        init(); // initialize parent array
        Collections.sort(edges); // ascending order sorting of edges O(ElogE)

        int MSTcost = 0;
        int count = 0; // kitne edges include kare

        for(int i=0; count<V-1; i++) { // O(V)
            Edge e = edges.get(i);
            // sr, dest, wt
            int parA = find(e.src); // src = a
            int parB = find(e.dest); // dest = b

            if(parA != parB) { // no cycle
                union(e.src, e.dest);
                MSTcost += e.wt;
                count++; // update count of edges
            }
        }
        System.out.println(MSTcost);
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
        //@SuppressWarnings("unchecked")
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        krushkalMST(graph, V);
    }
}
