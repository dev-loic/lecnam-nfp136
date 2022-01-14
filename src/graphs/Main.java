package graphs;

public class Main {

    public static void main(String args[]) {
        NonOrientedGraph graph = new NonOrientedGraph(7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 0);
        graph.addEdge(6, 0);

        graph.BFS(3);
        graph.DFS(3);
    }
}
