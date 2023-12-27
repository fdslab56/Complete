import java.util.*;

/**
 * Represents a generic graph using various representations.
 *
 * @param <T> The type of the elements in the graph.
 */
public class Graph<T> {
    private Map<T, Vertex<T>> vertices;
    private List<Edge<T>> edges;
    private Map<Vertex<T>, List<Edge<T>>> adjacencyList;
    private Map<Vertex<T>, Map<Vertex<T>, Edge<T>>> adjacencyMap;
    List<List<Edge<T>>> adjacencyMatrix;

    /**
     * Constructs an empty graph.
     */
    public Graph() {
        vertices = new HashMap<>();
        edges = new ArrayList<>();
        adjacencyList = new HashMap<>();
        adjacencyMap = new HashMap<>();
        adjacencyMatrix = new ArrayList<>();
    }

    /**
     * Gets the map of vertices.
     *
     * @return The map of vertices.
     */
    public Map<T, Vertex<T>> getVertices() {
        return vertices;
    }

    /**
     * Gets the adjacency map.
     *
     * @return The adjacency map.
     */
    public Map<Vertex<T>, Map<Vertex<T>, Edge<T>>> getAdjacencyMap() {
        return adjacencyMap;
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return The number of vertices.
     */
    public int numVertices() {
        return vertices.size();
    }

    /**
     * Returns an iterable collection of all vertices in the graph.
     *
     * @return An iterable collection of vertices.
     */
    public Iterable<Vertex<T>> vertices() {
        return vertices.values();
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return The number of edges.
     */
    public int numEdges() {
        return edges.size();
    }

    /**
     * Returns an iterable collection of all edges in the graph.
     *
     * @return An iterable collection of edges.
     */
    public Iterable<Edge<T>> edges() {
        return edges;
    }

    /**
     * Gets the edge between two vertices.
     *
     * @param u The source vertex.
     * @param v The destination vertex.
     * @return The edge between u and v.
     */
    public Edge<T> getEdge(Vertex<T> u, Vertex<T> v) {
        for (Edge<T> edge : adjacencyList.get(u)) {
            if (edge.v == v) {
                return edge;
            }
        }
        return null;
    }

    /**
     * Returns an array containing the two endpoints of a given edge.
     *
     * @param e The edge.
     * @return An array containing the two endpoints of the edge.
     */
    public Vertex<T>[] endVertices(Edge<T> e) {
        return new Vertex[] { e.u, e.v };
    }

    /**
     * Returns the vertex opposite of a given vertex on a given edge.
     *
     * @param v The vertex.
     * @param e The edge.
     * @return The opposite vertex.
     */
    public Vertex<T> opposite(Vertex<T> v, Edge<T> e) {
        return v == e.u ? e.v : e.u;
    }

    /**
     * Returns the out-degree of a given vertex.
     *
     * @param v The vertex.
     * @return The out-degree of the vertex.
     */
    public int outDegree(Vertex<T> v) {
        return adjacencyList.get(v).size();
    }

    /**
     * Returns the in-degree of a given vertex.
     *
     * @param v The vertex.
     * @return The in-degree of the vertex.
     */
    public int inDegree(Vertex<T> v) {
        int count = 0;
        for (List<Edge<T>> vertexEdges : adjacencyList.values()) {
            for (Edge<T> edge : vertexEdges) {
                if (edge.v == v) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Returns an iterable collection of outgoing edges from a given vertex.
     *
     * @param v The vertex.
     * @return An iterable collection of outgoing edges.
     */
    public Iterable<Edge<T>> outGoingEdges(Vertex<T> v) {
        return adjacencyList.get(v);
    }

    /**
     * Returns an iterable collection of incoming edges to a given vertex.
     *
     * @param v The vertex.
     * @return An iterable collection of incoming edges.
     */
    public Iterable<Edge<T>> inComingEdges(Vertex<T> v) {
        List<Edge<T>> incomingEdges = new ArrayList<>();
        for (List<Edge<T>> vertexEdges : adjacencyList.values()) {
            for (Edge<T> edge : vertexEdges) {
                if (edge.v == v) {
                    incomingEdges.add(edge);
                }
            }
        }
        return incomingEdges;
    }

    /**
     * Inserts a new vertex with the given element into the graph.
     *
     * @param x The element of the new vertex.
     * @return The newly inserted vertex.
     */
    public Vertex<T> insertVertex(T x) {
        Vertex<T> vertex = new Vertex<>(x);
        vertices.put(x, vertex);
        adjacencyList.put(vertex, new ArrayList<>());
        adjacencyMap.put(vertex, new HashMap<>());
        for (List<Edge<T>> row : adjacencyMatrix) {
            row.add(null);
        }
        List<Edge<T>> newRow = new ArrayList<>(Collections.nCopies(vertices.size(), null));
        adjacencyMatrix.add(newRow);
        return vertex;
    }

    /**
     * Inserts a new edge with the given element between two vertices in the graph.
     *
     * @param u         The source vertex.
     * @param v         The destination vertex.
     * @param edgeValue The element of the new edge.
     * @return The newly inserted edge.
     */
    public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v, T edgeValue) {
        Edge<T> edge = new Edge<>(u, v, edgeValue);
        edges.add(edge);
        adjacencyList.get(u).add(edge);
        adjacencyMap.get(u).put(v, edge);
        int uIndex = getIndex(u);
        int vIndex = getIndex(v);
        adjacencyMatrix.get(uIndex).set(vIndex, edge);
        return edge;
    }

    // Helper method to get index from vertices map
    private int getIndex(Vertex<T> vertex) {
        int index = 0;
        for (Vertex<T> v : vertices.values()) {
            if (v == vertex) {
                return index;
            }
            index++;
        }
        return -1; // Vertex not found, handle accordingly
    }
}
