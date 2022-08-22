<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Guía de Práctica de Laboratorio / Talleres / Centros de Simulación</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div>
<span style="font-weight:bold;">INFORME DE LABORATORIO</span><br />

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Grafos</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>08</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA DE PRESENTACIÓN:</td><td>21/08/2022</td><td>HORA DE PRESENTACIÓN:</td><td colspan="3"></td>
</tr>
<tr><td colspan="3">INTEGRANTE(s):
<ul>
<li>Cárdenas Martínez Franco Luchiano - fcardenasm@unsa.edu.pe</li>
<li>Carrillo Daza Barbara Rubi - bcarrillo@unsa.edu.pe</li>
<li>Diaz Portilla Carlo Rodrigo - cdiazpor@unsa.edu.pe</li>
<li>Hancco Condori Bryan Orlando - bhanccoco@unsa.edu.pe</li>
<li>Mamani Cañari Gabriel Antony - gmamanican@unsa.edu.pe</li>
</ul>
</td>
<td>NOTA:</td><td colspan="2"></td>
</<tr>
<tr><td colspan="6">DOCENTE(s):
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tbody>
</table>

<!-- Reportes -->
## SOLUCIÓN Y RESULTADOS

---

I. SOLUCIÓN DE EJERCICIOS/PROBLEMAS <br>
* La organización del repositorio es la siguiente
    ```sh
    ```
  * **Nota :** Para los ver los ejercicios propuestos deberá compilar y ejecutar "Test.java".
* **Implementacion del grafo**
Para la implementacion de un *grafo* repesentado mediante una *Lista de Adyacencia* se consideraron las siguientes clases
	```bash
	.
	├── Graph.java
	└── Vertice.java
	```
	- Para la clase **Vertice.java** se consideraron los siguientes atributos
	```java
	public class Vertice<E>{
	  E data;
 	  ArrayList<Vertice<E>> adjacentVertices;
	  ...
	 }
	```
	- Del mismo modo se considero necesario tener metodso para agregar vertices adyacentes y eliminar los vertices adyacentes, al tener estos almacenados en un arrayList luego de verificar la existencia el vertice a añadir o eliminar, podemos reutilizar los metodos 	```add()``` y remove ```remove()``` que nos proporciona un arrayList.
	
	```java
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
	```	
							
	- En la implementacion  la clase **Graph.java** se consideraron los siguientes atributos.
							
	```java
	public class Graph<E> {
      private ArrayList<Vertice<E>> vertices;
  	  private int numVertices;	
	  ...
	}
	```	
	- Ademas de eso tenemos el emtodo ```addEdege(E from, E to)``` el cual agrega una arista desde un vertice 'from' a un vertice 'to', primero verifica la existencia de 'from' y de 'to' , en el caso no existan ambos el metodo de detiene, para posterniro mente crearlos en caso no existan , y luego seañade el vertice como adyacente a 'to'.
	    ```java
	    public boolean addEdge(E from, E to) {
		Vertice fromV = null, toV = null;
		for (Vertice v : vertices) {
		    if (from.equals(v.data)) { 
			fromV = v;
		    } else if (to.equals(v.data)) { 
			toV = v;
		    }
		    if (fromV != null && toV != null) {
			break; 
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
	    ```  
	
	- Del mismo modo podemos resaltar el metodo ```removeEdge(E from, E to)```  el cual elimina la arista del vertice 'from' al vertice 'to',  en primer lugar busca el vertice , en caso no lo encuentre retorna false y no elmina ningun vertice , y de lo contrario elimina la arista de 'from' al vertice 'to'.
	 ```java
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
	``` 
	- Tambien un metodo ```toString()``` ,que recorre vertice por vertice accediendo a cada una de las listas de adyacencia , para organizar la impresion de datos, esto nos sirvio para hacer una pequeña prueba de la ejecucion de este grafo.
	```java
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
    ``` 
	
	- Luego de la ejecución de esta clase obtenemos:
	```bash
		Vertex: mario
		Adjacent vertices: giraldo 
		Vertex: giraldo
		Adjacent vertices: 
		Vertex: karen
		Adjacent vertices: mario 
		Vertex: jesus
		Adjacent vertices: mario franco jose 
		Vertex: franco
		Adjacent vertices: karen 
		Vertex: jose
		Adjacent vertices: jesus 
	``` 
	
	---

* **Implementacion del BSF y DFS** 

  * Algoritmo Breadth First Search
  
    En la implementación del algoritmo <code>Breadth First Search</code> se crea un <code>HashMap</code> que tiene la función de mantener un registro de los vertices que ya fueron visitados por el algoritmo, donde se tiene una clave que es el vértice y valor <code>boolean</code>.
    
    Posteriormente se crea una <code>Queue</code> que es responsable de agregar los vértices que van a ser visitados por el algoritmo, luego con un ciclo se itera sobre cada vertice adyacente del vertice en el que se encuentra ahora la cola y finalmente se cambia el valor <code>boolean</code> del <code>HashMap</code> para indicar que el vértice ya fue visitado.
  
  ```java
    Breadth First Search:
    Vertice visitado: karen
    Vertice visitado: franco
    Vertice visitado: gabriel
    Vertice visitado: anthony
  ```
    * Algoritmo Depth First Search

      Para la implementación del algoritmo Depth First Search se hace uso de la recursividad, teniendo como variable global al <code>HashMap</code> que tiene registro de las visitas a los vértices y el grafo.

      En el constructor se inicia el <code>HashMap</code> por lo que en el algoritmo únicamente se debe indicar el vértice por donde se debe iniciar el recorrido, de esta manera se itera sobre cada vértice adyacente y aplicando recursividad a cada uno <code>DFS(Vertice<E> vertice)</code>.

    ```java
    Breadth First Search:
    Vertice visitado: gabriel
    Vertice visitado: anthony
    Vertice visitado: karen
    Vertice visitado: franco
    Vertice visitado: jose
  ```

* **Implementación de Dijkstra** 
  Se realizó el siguiente test:
  ```java
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

        showEdges();
        graph.dijkStra(0);
  ```
  Para el algoritmo de Dijkstra se debe implementar una clase llamada "Dijkstra" que contenga un método "dijkstra" que reciba el index del nodo de partida y retorne un arreglo de enteros que contenga la distancia de cada nodo al nodo de partida. Los resultados obtenidos son 
  
  ```java
  A   0.0    A
  B   3.0    A C B
  C   2.0    A C
  D   7.0    A C B E D
  E   4.0    A C B E
	```
  Donde el segundo valor es la distancia recorrida y el tercer valor es el camino que se tuvo que recorrer para poder llegar al nodo.

  A su vez se el método showEdges() nos muestra la matriz del grafo.
  ```java
  [0, 10, 2, 0, 0]
  [0, 0, 0, 0, 1]
  [0, 1, 0, 0, 7]
  [0, 0, 0, 0, 0]
  [0, 0, 0, 3, 0]
  ```	
  
* **Solución del ejercicio**

* **EJERCICIO 5 - Método Adicional** 
 - Se agrego un método content en el cual se ingresan dos grafos y se indica si uno se encuentro contenido en el otro retorna true si es que está contenido y false si no lo está, para esto, se recorre nodo a nodo con un for y con otro for interno el array que existe en cada nodo para compararlos.
	
  - Dentro de Un grafo de palabras, cada vertice es una palabra, siendo 2 palabras adyacentes si solamente difieren
    en una posición.
  - El grafo definido las palabras: words, cords, corps, coops, crops, drops, drips, grips, gripe, grape, graph. Resulta.
  	![imagen](ejercicio4/1.png)
	![imagen](ejercicio4/2.png)
	![imagen](ejercicio4/3.png)
	![imagen](ejercicio4/4.png)
	![imagen](ejercicio4/5.png)
	![imagen](ejercicio4/6.png)
	![imagen](ejercicio4/7.png)
	![imagen](ejercicio4/8.png)
	![imagen](ejercicio4/9.png)
	![imagen](ejercicio4/10.png)
	![imagen](ejercicio4/11.png)
  - La resultante lista de adyacencia es:
	![imagen](ejercicio4/12.png)
* **Método adicional** 
  ```java
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
```  
		   
- Se llamó a otros dos métodos para que el método sea más ordenado y más entendible, estos dos métodos fueron: indexOf (se busca el vertice del grafo pequeño en los vertices del grafo contenedor) y isContentArrayVertice (se indica si el array del grafo contenido realmente está en el grafo contenedor)	 
```java
private boolean isContentArrayVertice(Object vertices2, Object vertices3) {
     System.out.println(vertices2);
     for (Vertice<E> i : vertices2) {
       if (indexOf(i.data, vertices3) < 0)
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
```	
* EJECUCIÓN
 - En la ejecución mostrada vemos cómo un grafo pequeño es casi igual excepto que en uno de sus nodos tiene 3 elementos y el original tiene 2 asi que devolverá FALSE, se ve en la consola.
![imagen](https://user-images.githubusercontent.com/90292110/185838756-a2a42f14-fd5a-4a35-a8b6-c192903d1202.png)

II. Cuestionario
* ¿Cuantas variantes del algoritmo de Dijkstra hay y cuál es la diferencia entre ellas?
  * **Versión con cola de prioridades :** Es una versión en la cual se usan colas que tienen cierta prioridad para que el algoritmo sepa que nodo se va a visitar primero. 
  * **Versión con montículos(heaps) :**  Es una versión en la cual se usan montículos(heaps) en el cuál cada nodo hijo tiene un valor mayor al que de su padre. 
  
  
*  Invetigue sobre los ALGORITMOS DE CAMINOS MINIMOS e indique, ¿Qué similitudes encuentra, 
   qué diferencias, en qué casos utilizar y porque?

   * Algoritmos de caminos mínimos:

      * Dijkstra: 

        Realiza operaciones (sumas y comparaciones) para determinar la longitud del camino más corto entre dos vértices de un grafo ponderado simple, conexo y no dirigido.

      * Bellman-Ford: 
      
        Devuelve un valor booleano, si encuentra pesos negativos, en caso contrario calcula y devuelve el camino con un coste mínimo en un grafo ponderado

      * Algoritmo de Búsqueda A*: 
      
        Es una combinación entre búsquedas del Breadth First Search y Depth First Search.

      * Algoritmo de Floyd-Warshall: 
      
        El algoritmo de Warshall es un ejemplo de algoritmo booleano. A partir de una tabla inicial compuesta de 0s (no hay correspondencia inicial en el grafo) y 1s (hay una correspondencia, llamase “flecha”, entre nodos), obtiene una nueva matriz en la que se muestran todas las posibles uniones entre nodos.

      * Algoritmo de Johnson: 
      
        Algoritmo que hace uso de dos algoritmos anteriormente mencionados: a) Algortimo de Dijkstra, b) Algoritmo de Bellman-Ford

    * Similitudes

      La principal semejanza entre estos algoritmos es la función de poder encontrar el camino más corto y el más eficiente al objetivo que se propone.

    * Diferencias

      La principal diferencia entre estos algoritmos es la forma en la que hallan el camino más corto, por una parte, algunos tienes en cuenta pesos y se evaluan entre otros pesos de diferentes de caminos para hallar el más óptimo, por otro lado, algoritmos como el de Floyd-Warshall en el que se usan matrices.

    * Cuando usarlos

      Cuando se habla de recorridos mínimos las principales aplicaciones son:

      * Aplicaciones para Sistemas de información geográficos

      * Routers
      
      * Enrutamiento de aviones
  
III. CONCLUSIONES

-  Los amplia amplitud de aplicaciones que posee el grafo, sea en las ciencias o en las humanidades, hacen que su implementación
   sea una muy importante, aprovechandose así, todas sus bondades
-  Las representaciones del grafo, basadas en la adyacencia y siendo una matriz o una lista, son muy útiles para una comprensión
   rápida de la información del grafo.
-  Los recorridos de los grafos (BFS y DFS) y los algoritmos de caminos mínimos (Dijkstra), son métodos muy importantes que garantizan
   visitar/procesar cada uno de los nodos y poder determinar el camino/ruta más corta, dado un nodo de origen respectivamente.
-  La implementación y/o desarrollo de cada uno de los ejercicios planteados fue un muy importante reto a asumir, pero gracias a la
   información planteada en la guía, el proceso fue mucho más llevadero 

---

## RETROALIMENTACIÓN GENERAL
 <pre>

 </pre>
---

### REFERENCIAS Y BIBLIOGRAFÍA
<ul>
    <li>https://www.w3schools.com/java/</li>
    <li>https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers</li>
    <li>https://docs.oracle.com/javase/tutorial/java/generics/types.html</li>
</ul>
