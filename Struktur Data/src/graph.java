import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class graph {
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++)
            if (degree(G, v) > max)
                max = degree(G, v);
        return max;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count / 2; // each edge counted twice
    }

    public static void main(String[] args) {
        StdOut.print("Enter number of vertices: ");
        int V = StdIn.readInt();
        Graph graph = new Graph(V);

        StdOut.print("Enter number of edges: ");
        int E = StdIn.readInt();
        StdOut.println("Enter edges (format: v w):");

        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            graph.addEdge(v, w);
        }

        StdOut.println("Graph adjacency list:");
        for (int v = 0; v < graph.V(); v++) {
            StdOut.print(v + ": ");
            for (int w : graph.adj(v)) {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }
    }
}
