import java.util.*;

/**
 * The Tree class represents a generic tree data structure.
 * It allows the creation, manipulation, and analysis of trees with arbitrary
 * data types.
 */
public class MyTree<T> implements Tree<T> {
    public TreeNode<T> root;

    /**
     * Constructs a tree with the specified root data.
     *
     * @param rootData The data for the root of the tree.
     */
    public MyTree(T rootData) {
        root = new TreeNode<>(rootData);
    }

    /**
     * Displays the tree structure.
     */
    public void display() {
        try {
            display(root, 0);
        } catch (Exception e) {
            handleException(e);
        }
    }

    /**
     * Displays the tree structure starting from the given node and its children
     * recursively.
     * 
     * @param node  The current node being displayed.
     * @param level The level of the node in the tree (used for indentation in the
     *              display).
     */
    public void display(TreeNode<T> node, int level) {
        try {
            StringBuilder prefix = new StringBuilder("  ".repeat(level));
            System.out.println(prefix + "|__ " + node.data);
            for (TreeNode<T> child : node.children) {
                display(child, level + 1);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    /**
     * Retrieves the siblings of a given node in the tree.
     * Siblings are nodes that share the same parent as the given node.
     * 
     * @param node The node whose siblings are to be retrieved.
     * @return A list of siblings or null if the node is the root or not found.
     */
    public List<TreeNode<T>> getSiblings(TreeNode<T> node) {
        try {
            TreeNode<T> parent = getParent(root, node);
            if (parent != null) {
                List<TreeNode<T>> siblings = new LinkedList<>();
                for (TreeNode<T> child : parent.children) {
                    if (child != node) {
                        siblings.add(child);
                    }
                }
                return siblings;
            }
            return null;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    /**
     * Retrieves the parent node of a given target node in the tree.
     * 
     * @param current The current node being examined.
     * @param target  The node for which the parent is to be found.
     * @return The parent node of the target node if found; otherwise, null.
     */
    public TreeNode<T> getParent(TreeNode<T> current, TreeNode<T> target) {
        try {
            if (current == null || current == target) {
                return null;
            }
            for (TreeNode<T> child : current.children) {
                if (child == target) {
                    return current;
                }
                TreeNode<T> parent = getParent(child, target);
                if (parent != null) {
                    return parent;
                }
            }
            return null;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    /**
     * Retrieves the list of leaf nodes in the tree.
     * Leaf nodes are nodes without any children.
     * 
     * @return A list containing all the leaf nodes in the tree.
     */
    public List<TreeNode<T>> getLeaves() {
        try {
            List<TreeNode<T>> leaves = new LinkedList<>();
            getLeaves(root, leaves);
            return leaves;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    /**
     * Recursively collects leaf nodes starting from the given node into the
     * provided list.
     * 
     * @param node   The current node being examined.
     * @param leaves The list to store the found leaf nodes.
     */
    public void getLeaves(TreeNode<T> node, List<TreeNode<T>> leaves) {
        try {
            if (node.children.isEmpty()) {
                leaves.add(node);
            }
            for (TreeNode<T> child : node.children) {
                getLeaves(child, leaves);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    /**
     * Retrieves the list of internal nodes in the tree.
     * Internal nodes are nodes that have at least one child.
     * 
     * @return A list containing all the internal nodes in the tree.
     */
    public List<TreeNode<T>> getInternalNodes() {
        try {
            List<TreeNode<T>> internalNodes = new LinkedList<>();
            getInternalNodes(root, internalNodes);
            return internalNodes;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    /**
     * Recursively collects internal nodes starting from the given node into the
     * provided list.
     * 
     * @param node          The current node being examined.
     * @param internalNodes The list to store the found internal nodes.
     */
    public void getInternalNodes(TreeNode<T> node, List<TreeNode<T>> internalNodes) {
        try {
            if (!node.children.isEmpty()) {
                internalNodes.add(node);
            }
            for (TreeNode<T> child : node.children) {
                getInternalNodes(child, internalNodes);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    /**
     * Retrieves the list of edges in the tree, represented as strings in the format
     * "parent - child".
     * 
     * @return A list containing the string representations of the edges in the
     *         tree.
     */
    public List<String> getEdges() {
        try {
            List<String> edges = new LinkedList<>();
            getEdges(root, edges);
            return edges;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    /**
     * Recursively collects edges starting from the given node and populates the
     * provided list.
     * Each edge is represented as a string "parent - child".
     * 
     * @param node  The current node being examined.
     * @param edges The list to store the string representations of edges.
     */
    public void getEdges(TreeNode<T> node, List<String> edges) {
        try {
            for (TreeNode<T> child : node.children) {
                edges.add(node.data + " - " + child.data);
                getEdges(child, edges);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    /**
     * Retrieves the path from the root to the specified target node.
     * 
     * @param target The target node for which the path is to be found.
     * @return A list containing the sequence of node values from the root to the
     *         target node.
     */
    public List<T> getPath(TreeNode<T> target) {
        List<T> path = new ArrayList<>();
        if (!getPath(root, target, path)) {
            return Collections.emptyList();
        }
        return path;
    }

    /**
     * Recursively finds the path from the current node to the target node and
     * populates the provided path list.
     * 
     * @param current The current node being examined.
     * @param target  The target node for which the path is to be found.
     * @param path    The list to store the path of node values.
     * @return True if the path to the target node is found; otherwise, false.
     */
    public boolean getPath(TreeNode<T> current, TreeNode<T> target, List<T> path) {
        if (current == null) {
            return false;
        }
        path.add(current.data);
        if (current == target) {
            return true;
        }
        for (TreeNode<T> child : current.children) {
            if (getPath(child, target, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * Calculates the depth of a specified node in the tree.
     * 
     * @param node The node for which the depth is to be found.
     * @return The depth of the node in the tree.
     */
    public int getDepth(TreeNode<T> node) {
        try {
            return getDepth(root, node, 0);
        } catch (Exception e) {
            handleException(e);
            return -1;
        }
    }

    /**
     * Recursively calculates the depth of a specified target node from the current
     * node in the tree.
     * 
     * @param current The current node being examined.
     * @param target  The target node for which the depth is to be found.
     * @param depth   The current depth in the recursion.
     * @return The depth of the target node if found; otherwise, -1.
     */
    public int getDepth(TreeNode<T> current, TreeNode<T> target, int depth) {
        try {
            if (current == null) {
                return -1;
            }
            if (current == target) {
                return depth;
            }
            for (TreeNode<T> child : current.children) {
                int result = getDepth(child, target, depth + 1);
                if (result != -1) {
                    return result;
                }
            }
            return -1;
        } catch (Exception e) {
            handleException(e);
            return -1;
        }
    }

    /**
     * Calculates the height of the entire tree starting from the root node.
     * 
     * @return The height of the tree.
     */
    public int getHeight() {
        try {
            return getHeight(root);
        } catch (Exception e) {
            handleException(e);
            return 0;
        }
    }

    /**
     * Recursively calculates the height of a specified node in the tree.
     * 
     * @param node The node for which the height is to be found.
     * @return The height of the node in the tree.
     */
    public int getHeight(TreeNode<T> node) {
        try {
            if (node == null) {
                return 0;
            }
            int maxHeight = 0;
            for (TreeNode<T> child : node.children) {
                int childHeight = getHeight(child);
                maxHeight = Math.max(maxHeight, childHeight);
            }
            return 1 + maxHeight;
        } catch (Exception e) {
            handleException(e);
            return 0;
        }
    }

    /**
     * Retrieves a subtree rooted at the specified node.
     * 
     * @param node The root node of the subtree.
     * @return A new Tree representing the subtree or null if an exception occurs.
     */
    public MyTree<T> getSubtree(TreeNode<T> node) {
        try {
            MyTree<T> subtree = new MyTree<>(node.data);
            copySubtree(node, subtree.root);
            return subtree;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    /**
     * Recursively copies the subtree rooted at the source node to the target node.
     * 
     * @param source The root of the source subtree to be copied.
     * @param target The root of the target subtree where the copy will be placed.
     */
    public void copySubtree(TreeNode<T> source, TreeNode<T> target) {
        try {
            for (TreeNode<T> child : source.children) {
                TreeNode<T> newChild = new TreeNode<>(child.data);
                target.addChild(newChild);
                copySubtree(child, newChild);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    /**
     * Handles exceptions by printing a generic message with the exception details.
     * 
     * @param e The exception that occurred.
     */
    public void handleException(Exception e) {
        System.err.println("An exception occurred: " + e.getMessage());
    }
}