package graph;
import java.util.*;

class  Graph {
    private  final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    public int V() {return V;}
    public int E() {return E;}

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (int w : adj[v]) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)){
            if (!marked[w]) {
                dfs(G, w);

            }

        }
    }
    public boolean marked(int v) {return marked[v];}
    public int count() {return count;}
}

class BreadFistSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadFistSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer>queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v) {return marked[v];}
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.addFirst(x);
        }
        path.addFirst(s);
        return path;
    }
}

class TestGraph {
    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 5);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(3, 5);

        System.out.println("Graph Representation (Adjacency List):");
        G.printGraph();

        System.out.println("\nDepth-First Search (DFS) from vertex 0:");
        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
                System.out.print(v + " ");
            }
        }

        System.out.println("\n\nBreadth-First Search (BFS) Shortest Path from vertex 0:");
        BreadFistSearch bfs = new BreadFistSearch(G, 0);
        for (int v = 0; v < G.V(); v++) {
            System.out.print("Path to " + v + ":");
            if (bfs.hasPathTo(v)) {
                for (int x : bfs.pathTo(v)) {
                    System.out.print(x + " ");
                }
            }else {
                System.out.print("No path");
            }
            System.out.println();
        }
    }
}