import java.util.*;

public class BreadthFirstSearch<E> {
	public BreadthFirstSearch() {
		
	}
	public void BFS(Graph<E> graph, Vertice<E> vertice) {
    HashMap<Vertice<E>, Boolean> nodosVisitados = new HashMap<Vertice<E>, Boolean>();
		
		for(Vertice<E> verticex : (ArrayList<Vertice<E>>)graph.getVertices()) {
			nodosVisitados.put(verticex, false);
		}

    LinkedList<Vertice<E>> queue = new LinkedList<Vertice<E>>();

		nodosVisitados.replace(vertice,  true);
		queue.add(vertice);

    while (queue.size() != 0) {
			vertice = queue.poll();
			System.out.println("[" + vertice + "]");
			
			for (Vertice<E> adyacente : vertice.getAdjacentVertex()) {
				Vertice<E> n = adyacente;
				if (!nodosVisitados.get(n)) {
					nodosVisitados.replace(n,  true);
					queue.add(n);
				}
			}
		}
	}
}
