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
  ```java
	//Código resaltante
	```   
* **Implementación de Dijkstra** 
  ```java
	//Código resaltante
	```
* **Solución del ejercicio**

* **Método adicional** 
  ```java
	//Código resaltante
	```  
II. Cuestionario
* ¿Cuantas variantes del algoritmo de Dijkstra hay y cuál es la diferencia entre ellas?
  
*  Invetigue sobre los ALGORITMOS DE CAMINOS MINIMOS e indique, ¿Qué similitudes encuentra, 
   qué diferencias, en qué casos utilizar y porque?
  
III. CONCLUSIONES

- 
- 
- 
- 

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
