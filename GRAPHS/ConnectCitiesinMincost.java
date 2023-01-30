package GRAPHS;

import java.util.PriorityQueue;

public class ConnectCitiesinMincost {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;
        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.cost-e2.cost; // ascending order sorting on the basis of cost
        }
    }

    public static int connectCities(int cities[][]) { // MST prims modified
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                // neighbour call
                for(int i=0; i<cities[curr.dest].length; i++) {
                    if(cities[curr.dest][i] != 0) { // koe edge exist krta hai kya
                        pq.add(new Edge(i, cities[curr.dest][i])); // add krdo pq mae
                    }
                }
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int cities [][] = {{0,1,2,3,4},
                           {1,0,5,0,7},
                           {2,5,0,6,0},
                           {3,0,6,0,0},
                           {4,7,0,0,0}};
        System.out.println(connectCities(cities));
    }
}
