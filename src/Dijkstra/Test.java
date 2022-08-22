package Dijkstra;

public class Test {
    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra(5);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdges(0, 1, 10);
        graph.addEdges(0, 2, 2);
        graph.addEdges(2, 1, 1);
        graph.addEdges(2, 4, 7);
        graph.addEdges(1, 4, 1);
        graph.addEdges(4, 3, 3);

        Dijkstra.showEdges();
        graph.dijkStra(0);

    }
}
