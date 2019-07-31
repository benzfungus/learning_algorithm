package graph;

public class Graph {
    private final int V; // 顶点数
    private int E; // 边数
    private Bag<Integer>[] adj; // 邻接表
    public Graph(int V) {

    }

    public Graph(In in) {

    }

    int V() {
        return 0;
    }

    int E() {
        return 0;
    }

    void addEdge(int v, int w) {

    }

    Iterable<Integer> adj(int v) {
        return null;
    }

    public static int degree(Graph G, int v){
        int degree = 0;
        for(int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G){
        int max = 0;
        for(int v = 0; v < G.V(); v++){
            if(degree(G, v) > max)
                max = degree(G, v);
        }
        return max;
    }

    public static double avgDegree(Graph G){
        return 2 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for(int v = 0; v < G.V(); v++)
            for(int w : G.adj(v))
                if(v == w) count++;
        return count / 2; // 每条边都被记过两次
    }
    @Override
    public String toString(){
        String s = V + " vertices, " + E + " edges\n";
        for ( int v = 0; v < V; v++){
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
    
}