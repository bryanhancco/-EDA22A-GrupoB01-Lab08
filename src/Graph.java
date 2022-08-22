import java.util.*;

public class Graph<E> {

  private ArrayList<Vertice<E>> vertices;
  private int numVertices;

  public Graph() {
    vertices = new ArrayList<>();
  }

  // Agregar una arista desde un vertice 'from' a un vertice 'to'
  public boolean addEdge(E from, E to) {
    Vertice<E> fromV = null, toV = null;
    for (Vertice<E> v : vertices) {
      if (from.equals(v.data)) { // verificando si 'from' existe
        fromV = v;
      } else if (to.equals(v.data)) { // verificando si 'to' existe
        toV = v;
      }
      if (fromV != null && toV != null) {
        break; // ambos nodos deben existir, si no paramos
      }
    }
    if (fromV == null) {
      fromV = new Vertice(from);
      vertices.add(fromV);
      numVertices++;
    }
    if (toV == null) {
      toV = new Vertice(to);
      vertices.add(toV);
      numVertices++;
    }
    return fromV.addAdjacentVertex(toV);
  }

  // Eliminamos la arista del vertice 'from' al vertice 'to'
  public boolean removeEdge(E from, E to) {
    Vertice fromV = null;
    for (Vertice v : vertices) {
      if (from.equals(v.data)) {
        fromV = v;
        break;
      }
    }
    if (fromV == null) {
      return false;
    }
    return fromV.removeAdjacentVertex(to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Vertice<E> v : vertices) {
      sb.append("Vertex: ");
      sb.append(v.data);
      sb.append("\n");
      sb.append("Adjacent vertices: ");
      for (Vertice<E> v2 : v.adjacentVertices) {
        sb.append(v2.data);
        sb.append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public int getNumEdges() {
    int count = 0;
    for (int i = 0; i < this.vertices.size(); i++) {
      count += this.vertices.get(i).adjacentVertices.size();
    }
    return count;
  }

  public int getNumVertices() {
    return numVertices;
  }

  public void setNumVertices(int numVertices) {
    this.numVertices = numVertices;
  }

  public int countConnectedComponents() {
    return -1;
  }

  public boolean removeVertex(int vertex) {
    return false;
  }

  public boolean content(Graph<E> graphContenido, Graph<E> graphContenedor) {
    if (graphContenido.vertices.size() > graphContenedor.vertices.size())
      return false;
    for (Vertice<E> i : graphContenido.vertices) {
      int indi = indexOf(i.data, graphContenedor.vertices);
      if (indi < 0)
        return false;
      else {
        if (i.vertices != null) {
          boolean isContent = isContentArrayVertice(i.vertices, graphContenedor.vertices.get(indi).vertices);
          if (!isContent)
            return false;
        }
      }
    }
    return true;

  }

  private boolean isContentArrayVertice(ArrayList<Vertice<E>> contenido, ArrayList<Vertice<E>> contenedor) {
    System.out.println(contenido);
    for (Vertice<E> i : contenido) {
      if (indexOf(i.data, contenedor) < 0)
        return false;
    }
    return true;
  }

  private int indexOf(E data, ArrayList<Vertice<E>> contenedor) {
    for (int i = 0; i < contenedor.size(); i++) {
      if (data.equals(contenedor.get(i).data))
        return i;
    }
    return -1;
  }

  public static void main(String args[]) {
    Graph<String> graph = new Graph<String>();
    graph.addEdge("mario", "giraldo");
    graph.addEdge("karen", "mario");
    graph.addEdge("jesus", "mario");
    graph.addEdge("franco", "karen");
    graph.addEdge("jesus", "franco");
    graph.addEdge("jose", "jesus");
    graph.addEdge("carlo", "jose");
    System.out.println(graph);
  }

  public ArrayList<Vertice<E>> getVertices() {
    return vertices;
  }
}
