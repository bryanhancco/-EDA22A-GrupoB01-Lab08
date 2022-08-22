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
	```java
	//Código resaltante
	```
* **Implementacion del BSF y DFS** 

  * Algoritmo Breadth First Search
  
    En la implementación del algoritmo <code>Breadth First Search</code> se crea un <code>HashMap</code> que tiene la función de mantener un registro de los vertices que ya fueron visitados por el algoritmo, donde se tiene una clave que es el vértice y valor <code>boolean</code>.
    
    Posteriormente se crea una <code>Queue</code> que es responsable de agregar los vértices que van a ser visitados por el algoritmo, luego con un ciclo se itera sobre cada vertice adyacente del vertice en el que se encuentra ahora la cola y finalmente se cambia el valor <code>boolean</code> del <code>HashMap</code> para indicar que el vértice ya fue visitado.
  
  ```java
    Vertice<String> vertice = graph.getVertices().get(3);
    bfs.BFS(graph, vertice);

    Breadth First Search:
    Nodos visitados:
    [franco]
    [karen]
    [mario]
    [ ]
  ```
    * Algoritmo Depth First Search

      Para la implementación del algoritmo Depth First Search se hace uso de la recursividad, teniendo como variable global al <code>HashMap</code> que tiene registro de las visitas a los vértices y el grafo.

      En el constructor se inicia el <code>HashMap</code> por lo que en el algoritmo únicamente se debe indicar el vértice por donde se debe iniciar el recorrido, de esta manera se itera sobre cada vértice adyacente y aplicando recursividad a cada uno <code>DFS(Vertice<E> vertice)</code>.

    ```java
    Vertice<String> vertice = graph.getVertices().get(3);
    dfs.DFS(vertice);

    Depth First Search:
    Nodos visitados:
    [franco]
    [karen]
    [mario]
    [ ]
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
