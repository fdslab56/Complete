/**
 * The {@code Vertex} class represents a vertex in a graph with a generic key.
 * It stores the key associated with the vertex.
 *
 * @param <T> The type of the key associated with the vertex.
 */
public class Vertex<T> {
    /**
     * The key associated with the vertex.
     */
    T key;

    /**
     * Constructs a new vertex with the specified key.
     *
     * @param key The key associated with the vertex.
     */
    Vertex(T key) {
        this.key = key;
    }
}
