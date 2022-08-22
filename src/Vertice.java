import java.util.*;
public class Vertice<E>{
  E data;
  ArrayList<Vertice<E>> adjacentVertices;

  public Vertice(E data){
    this.adjacentVertices = new ArrayList<>(); 
    this.data = data;
  }

  public boolean addAdjacentVertex(Vertice<E> to) {
    for (Vertice v : adjacentVertices) {
      // Verificando si ya existe
      if (v.data.equals(to.data)) {
        return false;
      }
    }
    this.adjacentVertices.add(to);

    return true;
  }

  public boolean removeAdjacentVertex(E to) {
    for (int i = 0; i < adjacentVertices.size(); i++) {
      // Encontrando vertice adjacente
      if (this.adjacentVertices.get(i).data.equals(to)) {
        this.adjacentVertices.remove(i);
        return true;
      }
    }
    return false;
  }
  public ArrayList<Vertice<E>> getAdjacentVertex(){
	  return this.adjacentVertices;
  }
  public String toString() {
	  return this.data.toString();
  }
}

