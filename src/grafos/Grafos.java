
package grafos;

// descargar librerías de https://jgrapht.org/ e incluir jgrapht-core
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class Grafos {

    public static void main(String[] args) {
        // Crear un grafo dirigido y ponderado (con distancias)
        // recibe por parametro el tipo de datos que será el nombre de los vértices y el tipo de aristas, en este caso: dirigido (une vértices) y poderado (tiene peso, en este caso las distancias)
        // en constructor se pasa la clase arista para que el grafo se instancia internamente
        Graph<String, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Agregar vértices
        //no permite vértices duplicados
        grafo.addVertex("Manizales");
        grafo.addVertex("Bogotá");
        grafo.addVertex("Medellín");
        grafo.addVertex("Cali");

        // Agregar aristas con distancias
        DefaultWeightedEdge a1 = grafo.addEdge("Manizales", "Bogotá");
        grafo.setEdgeWeight(a1, 290); // el 290 representa el peso que se le da a la arista, en este caso km de distancia

        DefaultWeightedEdge a2 = grafo.addEdge("Manizales", "Medellín");
        grafo.setEdgeWeight(a2, 200);

        DefaultWeightedEdge a3 = grafo.addEdge("Medellín", "Cali");
        grafo.setEdgeWeight(a3, 420);

        DefaultWeightedEdge a4 = grafo.addEdge("Bogotá", "Cali");
        grafo.setEdgeWeight(a4, 460);

        // Mostrar vértices
        System.out.println("Vértices: " + grafo.vertexSet());

        // Mostrar aristas con distancias
        System.out.println("\nDistancias entre ciudades:");
        for (DefaultWeightedEdge e : grafo.edgeSet()) {
            String origen = grafo.getEdgeSource(e);
            String destino = grafo.getEdgeTarget(e);
            double distancia = grafo.getEdgeWeight(e);
            System.out.println(origen + " -> " + destino + " = " + distancia + " km");
        }

        // Recorrer conexiones desde Manizales
        System.out.println("\nConexiones desde Manizales:");
        for (DefaultWeightedEdge e : grafo.outgoingEdgesOf("Manizales")) {
            System.out.println(" -> " + grafo.getEdgeTarget(e) + 
                               " (" + grafo.getEdgeWeight(e) + " km)");
        }
    }
}
