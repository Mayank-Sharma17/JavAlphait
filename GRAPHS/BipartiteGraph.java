package GRAPHS;
import java.util.*;

public class BipartiteGraph {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1)); 
        
        graph[1].add(new Edge(1, 0)); 
        graph[1].add(new Edge(1, 3)); 

        graph[2].add(new Edge(2, 4));  

        graph[3].add(new Edge(3, 1)); 
        graph[3].add(new Edge(3, 4)); 

        graph[4].add(new Edge(4, 2)); 
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) { // time comp-O(V+E), space comp O(v[vis]) + O(v[col]) = O(V)
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1; // assign with -1 means no color, here we use modified BFS
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) { // MBFS
                q.add(i);
                col[i] = 0; // 0-yellow

                while(!q.isEmpty()) {
                    int curr = q.remove(); // remove karke nieghbours ko dekhlo
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest-neighbour
                        if(col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0; // agar curr ka color 0 hai to next iska opposite 1 hoajeag agar 1 ha to 0 hoga
                            col[e.dest] = nextCol; // us pra vo color assign krdu
                            q.add(e.dest);// q mae next node add krdo
                        } else if(col[e.dest] == col[curr]) { // if color same at consecutive node
                            return false; // non bipartite 
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
            /*   
                       0      2
                      /      /
                     /      /
                    1      4
                     \    /
                      \  /
                       3
            */ 
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
