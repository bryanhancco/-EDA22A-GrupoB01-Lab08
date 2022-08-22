package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {

    private int edgesAmount;
    private int n;
    private ArrayList<String> vertex;
    private double[] distance;
    private static int[][] edges;
    private String[] path;
    private boolean[] isVisited;

    public Dijkstra(int n) {
        this.n = n;
        edgesAmount = 0;
        vertex = new ArrayList<String>(n);
        edges = new int[n][n];
        isVisited = new boolean[n + 1];
        distance = new double[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }

        path = new String[n];
        for (int i = 0; i < n; i++) {
            path[i] = "";
        }
    }

    public static void showEdges() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }

    }

    // getting the number of vertexes
    public int getSize(ArrayList<String> vertex) {
        return vertex.size();
    }

    public void addVertex(String s) {
        vertex.add(s);
    }

    // getting the first adjacent vertex of the vertex (index)
    public int getFirstCO(int index) {
        for (int i = 0; i < vertex.size(); i++) {
            if (edges[index][i] > 0)
                return i;
        }
        return n;
    }

    // getting the next vertex of the specified vertex (index)
    public int getNextCO(int index, int firstCO) {
        for (int i = firstCO + 1; i < vertex.size(); i++) {
            if (edges[index][i] > 0)
                return i;
        }
        return n;
    }

    public void addEdges(int e1, int e2, int weight) {
        edges[e1][e2] = weight;
        edgesAmount++;
    }

    public int getNumberOfEdges() {
        return edgesAmount;
    }

    public void dijkStra(int index) {

        int CO;
        int headIndex = index;
        distance[index] = 0;

        while (!isVisited[headIndex]) {

            CO = getFirstCO(headIndex);
            while (isVisited[CO]) {
                CO = getNextCO(headIndex, CO);
            }

            if (CO == n) {
                isVisited[headIndex] = true;
            } else {
                while (!isVisited[CO] && CO < n) {
                    isVisited[headIndex] = true;
                    double currentDis = distance[headIndex] + edges[headIndex][CO];
                    if (currentDis < distance[CO]) {
                        distance[CO] = currentDis;

                        path[CO] = path[headIndex] + " " + vertex.get(headIndex);
                    }

                    CO = getNextCO(headIndex, CO);

                }
            }

            headIndex = indexGet(distance, isVisited);

        }
        for (int i = 0; i < n; i++) {
            path[i] = path[i] + " " + vertex.get(i);
        }
        System.out.println("Initial node: " + vertex.get(index));
        for (int i = 0; i < n; i++) {
            System.out.println(vertex.get(i) + "   " + distance[i] + "   " + path[i]);
        }

    }

    public int indexGet(double[] distance, boolean[] isVisited) {
        int j = 0;
        double mindis = Double.POSITIVE_INFINITY;
        for (int i = 0; i < distance.length; i++) {
            if (!isVisited[i]) {
                if (distance[i] < mindis) {
                    mindis = distance[i];
                    j = i;
                }
            }
        }
        return j;
    }
}