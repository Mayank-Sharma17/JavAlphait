package GRAPHS;
import java.util.*;

public class Kahns_Algorithm {
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

        graph[2].add(new Edge(2, 3)); 
        
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0)); 
        graph[4].add(new Edge(4, 1));  

        graph[5].add(new Edge(5, 0)); 
        graph[5].add(new Edge(5, 2)); 
    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        // calculate indegree of each vertex
        for(int i=0; i<graph.length; i++) {
            int v = i; // Vertex is i

            for(int j=0; j<graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++; // sabke indegree inkal loo
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) { // 
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg); // calculate indegree
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i); // add in queue jiske indegree 0 hai
            }
        }

        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i); // neighbours 
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
      /*   
                   5         4
                   |\       /| 
                   |  \   /  |
                   |   >0<   |
                   >2        >1
                    \       /
                      \   /
                       >3
            */ 
            int V = 6;
            @SuppressWarnings("unchecked")
            ArrayList<Edge>[] graph = new ArrayList[V];
            createGraph(graph); 
            topSort(graph);
    }
}
