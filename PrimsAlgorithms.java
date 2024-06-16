import java.util.*;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<List<Edge>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjList.get(source).add(edge);
        adjList.get(destination).add(new Edge(destination, source, weight));
    }

    public int primMST() {
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] mstSet = new boolean[V];
        int[] parent = new int[V];

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (Edge e : adjList.get(u)) {
                int v = e.destination;
                int weight = e.weight;
                if (!mstSet[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
            }
        }

        int cost = 0;
        for (int i = 1; i < V; i++)
            cost += key[i];

        return cost;
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of nodes
        int m = scanner.nextInt(); // number of edges

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(u, v, w);
        }

        int minCost = graph.primMST();
        System.out.println(minCost);

        scanner.close();
    }
}
