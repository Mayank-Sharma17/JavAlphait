package GRAPHS;

public class DisjointSetDS {
    static int n = 7;
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
    public static void main(String[] args) { // optimized data structure constant time complexity O(4k)
        init();

        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
    }
}
