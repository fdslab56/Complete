import java.util.List;

/**
 * The Tree interface represents a generic tree data structure.
 * It allows the creation, manipulation, and analysis of trees with arbitrary
 * data types.
 *
 * @param <T> The type of elements stored in the tree.
 */
public interface Tree<T> {

    /**
     * Displays the tree structure.
     */
    void display();

    /**
     * Displays the tree structure starting from the given node and its children
     * recursively.
     *
     * @param node  The current node being displayed.
     * @param level The level of the node in the tree (used for indentation in the
     *              display).
     */
    void display(TreeNode<T> node, int level);

    /**
     * Retrieves the siblings of a given node in the tree.
     * Siblings are nodes that share the same parent as the given node.
     *
     * @param node The node whose siblings are to be retrieved.
     * @return A list of siblings or null if the node is the root or not found.
     */
    List<TreeNode<T>> getSiblings(TreeNode<T> node);

    /**
     * Retrieves the parent node of a given target node in the tree.
     *
     * @param current The current node being examined.
     * @param target  The node for which the parent is to be found.
     * @return The parent node of the target node if found; otherwise, null.
     */
    TreeNode<T> getParent(TreeNode<T> current, TreeNode<T> target);

    /**
     * Retrieves the list of leaf nodes in the tree.
     * Leaf nodes are nodes without any children.
     *
     * @return A list containing all the leaf nodes in the tree.
     */
    List<TreeNode<T>> getLeaves();

    /**
     * Recursively collects leaf nodes starting from the given node into the
     * provided list.
     *
     * @param node   The current node being examined.
     * @param leaves The list to store the found leaf nodes.
     */
    void getLeaves(TreeNode<T> node, List<TreeNode<T>> leaves);

    /**
     * Retrieves the list of internal nodes in the tree.
     * Internal nodes are nodes that have at least one child.
     *
     * @return A list containing all the internal nodes in the tree.
     */
    List<TreeNode<T>> getInternalNodes();

    /**
     * Recursively collects internal nodes starting from the given node into the
     * provided list.
     *
     * @param node          The current node being examined.
     * @param internalNodes The list to store the found internal nodes.
     */
    void getInternalNodes(TreeNode<T> node, List<TreeNode<T>> internalNodes);

    /**
     * Retrieves the list of edges in the tree, represented as strings in the format
     * "parent - child".
     *
     * @return A list containing the string representations of the edges in the
     *         tree.
     */
    List<String> getEdges();

    /**
     * Recursively collects edges starting from the given node and populates the
     * provided list.
     * Each edge is represented as a string "parent - child".
     *
     * @param node  The current node being examined.
     * @param edges The list to store the string representations of edges.
     */
    void getEdges(TreeNode<T> node, List<String> edges);

    /**
     * Retrieves the path from the root to the specified target node.
     *
     * @param target The target node for which the path is to be found.
     * @return A list containing the sequence of node values from the root to the
     *         target node.
     */
    List<T> getPath(TreeNode<T> target);

    /**
     * Recursively finds the path from the current node to the target node and
     * populates the provided path list.
     *
     * @param current The current node being examined.
     * @param target  The target node for which the path is to be found.
     * @param path    The list to store the path of node values.
     * @return True if the path to the target node is found; otherwise, false.
     */
    boolean getPath(TreeNode<T> current, TreeNode<T> target, List<T> path);

    /**
     * Calculates the depth of a specified node in the tree.
     *
     * @param node The node for which the depth is to be found.
     * @return The depth of the node in the tree.
     */
    int getDepth(TreeNode<T> node);

    /**
     * Recursively calculates the depth of a specified target node from the current
     * node in the tree.
     *
     * @param current The current node being examined.
     * @param target  The target node for which the depth is to be found.
     * @param depth   The current depth in the recursion.
     * @return The depth of the target node if found; otherwise, -1.
     */
    int getDepth(TreeNode<T> current, TreeNode<T> target, int depth);

    /**
     * Calculates the height of the entire tree starting from the root node.
     *
     * @return The height of the tree.
     */
    int getHeight();

    /**
     * Recursively calculates the height of a specified node in the tree.
     *
     * @param node The node for which the height is to be found.
     * @return The height of the node in the tree.
     */
    int getHeight(TreeNode<T> node);

    /**
     * Retrieves a subtree rooted at the specified node.
     *
     * @param node The root node of the subtree.
     * @return A new Tree representing the subtree or null if an exception occurs.
     */
    Tree<T> getSubtree(TreeNode<T> node);

    /**
     * Recursively copies the subtree rooted at the source node to the target node.
     *
     * @param source The root of the source subtree to be copied.
     * @param target The root of the target subtree where the copy will be placed.
     */
    void copySubtree(TreeNode<T> source, TreeNode<T> target);

    /**
     * Handles exceptions by printing a generic message with the exception details.
     *
     * @param e The exception that occurred.
     */
    void handleException(Exception e);
}
