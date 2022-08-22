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
  ```java
	//Código resaltante
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

* **Método adicional** 
  ```java
	//Código resaltante
	```  
II. Cuestionario
* ¿Cuantas variantes del algoritmo de Dijkstra hay y cuál es la diferencia entre ellas?
  * **Versión con cola de prioridades :** Es una versión en la cual se usan colas que tienen cierta prioridad para que el algoritmo sepa que nodo se va a visitar primero. 
  * **Versión con montículos(heaps) :**  Es una versión en la cual se usan montículos(heaps) en el cuál cada nodo hijo tiene un valor mayor al que de su padre. 
  
  
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
