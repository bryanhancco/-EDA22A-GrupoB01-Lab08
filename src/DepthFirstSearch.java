import java.util.*;

public class DepthFirstSearch<E> {
	private HashMap<Vertice<E>, Boolean> nodosVisitados;
	private Graph<E> grafo;

	public DepthFirstSearch(Graph<E> grafo) {
		this.nodosVisitados = new HashMap<Vertice<E>, Boolean>();
		this.grafo = grafo;
		for (Vertice<E> vertice : (ArrayList<Vertice<E>>) this.grafo.getVertices()) {
			this.nodosVisitados.put(vertice, false);
		}
	}

	public void DFS(Vertice<E> vertice) {
		this.nodosVisitados.replace(vertice, true);
		System.out.println("Vertice visitado: " + vertice);

		for (Vertice<E> adyacente : vertice.vertices) {
			if (!this.nodosVisitados.get(adyacente))
				DFS(adyacente);
		}
	}

	public static void main(String[] args) {
		Graph<String> graph = new Graph<String>();

		graph.addEdge("gabriel", "anthony");
		graph.addEdge("gabriel", "karen");
		graph.addEdge("franco", "karen");
		graph.addEdge("gabriel", "franco");
		graph.addEdge("jose", "gabriel");
		graph.addEdge("gabriel", "jose");

		DepthFirstSearch<String> bfs = new DepthFirstSearch<String>(graph);

		Vertice<String> vertice = graph.getVertices().get(0);

		System.out.println("Breadth First Search:");
		bfs.DFS(vertice);
	}
}
