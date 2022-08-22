public class test5 {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<String>();
        graph.addEdge("fraasasnco", "karen");
        graph.addEdge("jose", "jesus");
        graph.addEdge("carlo", "jose");
        graph.addEdge("barbara", "jose");
        graph.addEdge("jose", "barbara");
        graph.addEdge("yerick", "barbie");
        System.out.println(graph);

        Graph<String> graph2 = new Graph<String>();
        graph2.addEdge("fraasasnco", "karen");
        graph2.addEdge("jose", "jesus");
        graph2.addEdge("carlo", "jose");
        graph2.addEdge("barbara", "jose");
        graph2.addEdge("jose", "barbara");
        graph.addEdge("yerick", "barbie");
        System.out.println(graph2);

        System.out.println(graph.content(graph2, graph));
    }

}
