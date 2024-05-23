package BeaconBFS;

public class appBeacon {
    
    public static void main(String[] args) {
        
        In in = new In("movies.txt");
        Graph graph = new Graph();

        String line;
        while ((line = in.readLine()) != null) {
            String[] edge = line.split("/");
            String movie = edge[0];
            for (int i = 1; i < edge.length; i++) {
                graph.addEdge(movie, edge[i]); // relaciona os autores com o filme
            }
        }

        System.out.println("Vértices: " + graph.getTotalVertices());
        System.out.println("Arestas: " + graph.getTotalEdges());
        
        // Implememtar a busca por nomes e a distância entre eles
    }
}
