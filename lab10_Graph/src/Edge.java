/**
 * The {@code Edge} class represents an edge in a graph, connecting two
 * vertices.
 *
 * @param <T> The type of the data associated with the vertices and the edge.
 */
public class Edge<T> {
    /**
     * The source vertex of the edge.
     */
    Vertex<T> u;

    /**
     * The destination vertex of the edge.
     */
    Vertex<T> v;

    /**
     * The data associated with the edge.
     */
    T key;

    /**
     * Constructs a new edge between the specified source and destination vertices
     * with the given data.
     *
     * @param u   The source vertex.
     * @param v   The destination vertex.
     * @param key The data associated with the edge.
     */
    Edge(Vertex<T> u, Vertex<T> v, T key) {
        this.u = u;
        this.v = v;
        this.key = key;
    }
}
