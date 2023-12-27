import java.util.Scanner;

/**
 * The GraphRepresentation class provides a simple interactive console-based
 * interface
 * for managing a generic graph with string vertex values and string edge
 * values.
 * It allows users to insert vertices, insert edges, and display various
 * representations
 * of the graph such as edge list, adjacency list, adjacency map, and adjacency
 * matrix.
 */
public class GraphRepresentation {

    /**
     * The main method that serves as the entry point for the graph representation
     * program.
     * It initializes a graph and presents a menu for interacting with the graph.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Insert Vertex");
                System.out.println("2. Insert Edge");
                System.out.println("3. Display Edge List");
                System.out.println("4. Display Adjacency List");
                System.out.println("5. Display Adjacency Map");
                System.out.println("6. Display Adjacency Matrix");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the vertex value: ");
                        String vertexValue = scanner.next();
                        graph.insertVertex(vertexValue);
                        System.out.println("Vertex inserted successfully!");
                        break;

                    case 2:
                        System.out.print("Enter the source vertex value: ");
                        String sourceValue = scanner.next();
                        System.out.print("Enter the destination vertex value: ");
                        String destValue = scanner.next();
                        System.out.print("Enter the edge value: ");
                        String edgeValue = scanner.next();
                        Vertex<String> sourceVertex = graph.getVertices().get(sourceValue);
                        Vertex<String> destVertex = graph.getVertices().get(destValue);
                        if (sourceVertex != null && destVertex != null) {
                            graph.insertEdge(sourceVertex, destVertex, edgeValue);
                            System.out.println("Edge inserted successfully!");
                        } else {
                            System.out.println("Invalid vertices. Please insert vertices first.");
                        }
                        break;

                    case 3:
                        displayEdgeList(graph);
                        break;

                    case 4:
                        displayAdjacencyList(graph);
                        break;

                    case 5:
                        displayAdjacencyMap(graph);
                        break;

                    case 6:
                        displayAdjacencyMatrix(graph);
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }

    // Helper methods for displaying different graph representations

    private static void displayEdgeList(Graph<String> graph) {
        System.out.println();
        System.out.println("Edge List:");
        System.out.println();
        for (Edge<String> edge : graph.edges()) {
            System.out.println(edge.u.key + " -> " + edge.v.key + ": " + edge.key);
        }
        System.out.println();
    }

    private static void displayAdjacencyList(Graph<String> graph) {
        System.out.println();
        System.out.println("Adjacency List:");
        System.out.println();
        for (Vertex<String> vertex : graph.vertices()) {
            System.out.print(vertex.key + ": ");
            for (Edge<String> edge : graph.outGoingEdges(vertex)) {
                System.out.print(edge.v.key + "(" + edge.key + ") ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void displayAdjacencyMap(Graph<String> graph) {
        System.out.println();
        System.out.println("Adjacency Map:");
        System.out.println();
        for (Vertex<String> vertex : graph.getVertices().values()) {
            System.out.print(vertex.key + ": ");
            for (Vertex<String> adjacentVertex : graph.getAdjacencyMap().get(vertex).keySet()) {
                Edge<String> edge = graph.getAdjacencyMap().get(vertex).get(adjacentVertex);
                System.out.print(adjacentVertex.key + "(" + edge.key + ") ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void displayAdjacencyMatrix(Graph<String> graph) {
        System.out.println();
        System.out.println("Adjacency Matrix:");
        System.out.println();
        for (int i = 0; i < graph.numVertices(); i++) {
            for (int j = 0; j < graph.numVertices(); j++) {
                Edge<String> edge = graph.adjacencyMatrix.get(i).get(j);
                if (edge != null) {
                    System.out.print(edge.key + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
