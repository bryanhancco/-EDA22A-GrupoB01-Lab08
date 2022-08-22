import java.util.*;

public class DepthFirstSearch<E> {
	private HashMap<Vertice<E>, Boolean> nodosVisitados;
	private Graph<E> grafo;
	
	public DepthFirstSearch(Graph<E> grafo) {
    this.nodosVisitados = new HashMap<Vertice<E>, Boolean>();
		this.grafo = grafo;
		for(Vertice<E> vertice : (ArrayList<Vertice<E>>)this.grafo.getVertices()) {
			this.nodosVisitados.put(vertice, false);
		}
	}
	public void DFS(Vertice<E> vertice) {
	}
}
