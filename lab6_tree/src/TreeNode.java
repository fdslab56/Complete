import java.util.*;

/**
 * The TreeNode class represents a node in a generic tree data structure.
 * Each node contains data and references to its children nodes.
 */
public class TreeNode<T> {
    T data;
    List<TreeNode<T>> children;

    /**
     * Constructs a tree node with the specified data and initializes an empty list
     * for children nodes.
     *
     * @param data The data to be stored in the node.
     */
    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    /**
     * Adds a child node to the current node's list of children.
     *
     * @param child The child node to be added.
     */
    public void addChild(TreeNode<T> child) {
        children.add(child);
    }
}
