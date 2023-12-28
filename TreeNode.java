


import java.util.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Represents a node in a tree structure.
 *
 * @param <T> The type of data stored in the tree node.
 */
class TreeNode<T> {
    private T data;
    private LinkedList<TreeNode<T>> children;

    /**
     * Constructs a tree node with the given data.
     *
     * @param data The data to be stored in the tree node.
     */
    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }
    

    

    /**
     * Adds a child node to the current node.
     *
     * @param child The child node to be added.
     */
    public void addChildd(TreeNode<T> child) {
        this.children.add(child);
    }

    /**
     * Gets the children of the current node.
     *
     * @return The list of children nodes.
     */
    public LinkedList<TreeNode<T>> getChildren() {
        return this.children;
    }

    /**
     * Gets the data stored in the node.
     *
     * @return The data of the node.
     */
    public T getData() {
        return this.data;
    }
}

/**
 * Represents a tree data structure.
 *
 * @param <T> The type of data stored in the tree.
 */
class Tree<T> {
    private TreeNode<T> root;

    /**
     * Constructs a tree with the given root data.
     *
     * @param rootData The data for the root node of the tree.
     */
    public Tree(T rootData) {
        root = new TreeNode<>(rootData);
    }
    

    /**
     * Gets the root node of the tree.
     *
     * @return The root node.
     */
    public TreeNode<T> getRoot() {
        return root;
    }
    public String getInfixExpression() {
        StringBuilder infixExpression = new StringBuilder();
        buildInfixExpression(root, infixExpression);
        return infixExpression.toString();
    }
    
    private void buildInfixExpression(TreeNode<T> node, StringBuilder infixExpression) {
        if (node != null) {
            List<TreeNode<T>> children = node.getChildren();
            if (!children.isEmpty()) {
                if (children.size() > 0) {
                    infixExpression.append("(");
                    buildInfixExpression(children.get(0), infixExpression); // Left child
                    infixExpression.append(node.getData()); // Operator or operand
                }
                if (children.size() > 1) {
                    buildInfixExpression(children.get(1), infixExpression); // Right child
                    infixExpression.append(")");
                } else {
                    infixExpression.append(")"); // Close parenthesis for unary operator
                }
            } else {
                infixExpression.append(node.getData()); // Leaf node
            }
        }
    }
    
    
    
    /**
     * Finds the siblings of a given node.
     *
     * @param node The node to find siblings for.
     * @return The list of sibling nodes.
     */
    public List<TreeNode<T>> getSiblings(TreeNode<T> node) {
        List<TreeNode<T>> siblings = new LinkedList<>();
        if (node == root) {
            return siblings;
        }

        TreeNode<T> parent = getParent(root, node);
        if (parent != null) {
            for (TreeNode<T> child : parent.getChildren()) {
                if (child != node) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    /**
     * Lists the leaves of the tree.
     *
     * @param node The node to start listing leaves from.
     * @return The list of leaf nodes.
     */
    public List<TreeNode<T>> getLeaves(TreeNode<T> node) {
        List<TreeNode<T>> leaves = new LinkedList<>();
        if (node == null) {
            return leaves;
        }

        if (node.getChildren().isEmpty()) {
            leaves.add(node);
        } else {
            for (TreeNode<T> child : node.getChildren()) {
                leaves.addAll(getLeaves(child));
            }
        }

        return leaves;
    }
    
                
    

    /**
     * Lists the internal nodes of the tree.
     *
     * @param node The node to start listing internal nodes from.
     * @return The list of internal nodes.
     */
    public List<TreeNode<T>> getInternalNodes(TreeNode<T> node) {
        List<TreeNode<T>> internalNodes = new LinkedList<>();
        if (node == null) {
            return internalNodes;
        }

        if (!node.getChildren().isEmpty()) {
            internalNodes.add(node);
        }

        for (TreeNode<T> child : node.getChildren()) {
            internalNodes.addAll(getInternalNodes(child));
        }

        return internalNodes;
    }

    /**
     * Lists the edges of the tree as pairs of nodes.
     *
     * @param node The node to start listing edges from.
     * @return The list of edges.
     */
    public List<String> getEdges(TreeNode<T> node) {
        List<String> edges = new LinkedList<>();
        if (node == null) {
            return edges;
        }

        for (TreeNode<T> child : node.getChildren()) {
            edges.add(node.getData() + " -> " + child.getData());
            edges.addAll(getEdges(child));
        }

        return edges;
    }
    public void addChildd(T targetData, int targetDepth, TreeNode<T> child) {
        addChildd(root, targetData, 0, targetDepth, child);
    }
    
    private void addChildd(TreeNode<T> currentNode, T targetData, int currentDepth, int targetDepth, TreeNode<T> child) {
        if (currentDepth == targetDepth && currentNode.getData().equals(targetData)) {
            currentNode.addChildd(child);
        } else {
            for (TreeNode<T> node : currentNode.getChildren()) {
                addChildd(node, targetData, currentDepth + 1, targetDepth, child);
            }
        }
    }

    /**
     * Finds the path for a given node in the tree.
     *
     * @param target The node for which to find the path.
     * @return The list representing the path.
     */
    public List<T> getPath(TreeNode<T> target) {
        List<T> path = new LinkedList<>();
        buildPath(root, target, path);
        return path;
    }

    /**
     * Calculates the depth of a given node in the tree.
     *
     * @param node The node for which to calculate the depth.
     * @return The depth of the node.
     */
    public int getDepth(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        return calculateDepth(root, node, 0);
    }

    /**
     * Calculates the height of the tree.
     *
     * @return The height of the tree.
     */
    public int getHeight() {
        return calculateHeight(root);
    }

    /**
     * Retrieves the subtree rooted at a given node.
     *
     * @param node The node to serve as the root of the subtree.
     * @return The subtree.
     */
    /**
 * Returns a subtree of the current tree rooted at the specified node.
 *
 * @param node The node to be the root of the subtree.
 * @return A new Tree instance representing the subtree.
 */
public Tree<T> getSubtree(TreeNode<T> node) {
    Tree<T> subtree = new Tree<>(node.getData());
    subtree.root = node;
    return subtree;
}

/**
 * Returns the parent node of the specified target node in the tree.
 *
 * @param current The current node being examined.
 * @param target  The target node to find the parent for.
 * @return The parent node of the target, or null if the target is the root or not found.
 */
private TreeNode<T> getParent(TreeNode<T> current, TreeNode<T> target) {
    if (current == null) {
        return null;
    }
    if (current.getChildren().contains(target)) {
        return current;
    } else {
        for (TreeNode<T> child : current.getChildren()) {
            TreeNode<T> parent = getParent(child, target);
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }
}

/**
 * Builds the path from the root to the target node and adds it to the specified list.
 *
 * @param current The current node being examined.
 * @param target  The target node to build the path to.
 * @param path    The list to store the path.
 */
private void buildPath(TreeNode<T> current, TreeNode<T> target, List<T> path) {
    if (current == null) {
        return;
    }

    path.add(current.getData());

    if (current == target) {
        return;
    }

    for (TreeNode<T> child : current.getChildren()) {
        buildPath(child, target, path);
        if (path.get(path.size() - 1).equals(target.getData())) {
            return;
        }
        path.remove(path.size() - 1);
    }
}

/**
 * Calculates the depth of the target node in the tree.
 *
 * @param current The current node being examined.
 * @param target  The target node to calculate the depth for.
 * @param depth   The current depth in the recursive process.
 * @return The depth of the target node, or -1 if the target is not found.
 */
private int calculateDepth(TreeNode<T> current, TreeNode<T> target, int depth) {
    if (current == null) {
        return -1;
    }

    if (current == target) {
        return depth;
    }

    for (TreeNode<T> child : current.getChildren()) {
        int childDepth = calculateDepth(child, target, depth + 1);
        if (childDepth != -1) {
            return childDepth;
        }
    }

    return -1;
}

/**
 * Calculates the height of the tree rooted at the specified node.
 *
 * @param node The root node of the tree.
 * @return The height of the tree, or -1 if the tree is empty.
 */
private int calculateHeight(TreeNode<T> node) {
    if (node == null) {
        return -1;
    }

    int maxHeight = -1;
    for (TreeNode<T> child : node.getChildren()) {
        int childHeight = calculateHeight(child);
        if (childHeight > maxHeight) {
            maxHeight = childHeight;
        }
    }

    return maxHeight + 1;
}



}


/**
 * Represents information about a file or directory.
 */
class FileInfo {
    private String name;
    private int type; // 0-file, 1-directory
    private long size;
    private Date date;

    public FileInfo(String name, int type, long size, Date date) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public long getSize() {
        return size;
    }

    public Date getDate() {
        return date;
    }
}
/**
     * Constructs a FileInfo object with the specified attributes.
     *
     * @param name The name of the file or directory.
     * @param type The type of the item (0 for file, 1 for directory).
     * @param size The size of the item in bytes.
     * @param date The last modification date of the item.
     */
class TreeNode1 {
    private FileInfo data;
    private LinkedList<TreeNode1> children;

    public TreeNode1(FileInfo data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public void addChild(TreeNode1 child) {
        this.children.add(child);
    }

    public LinkedList<TreeNode1> getChildren() {
        return this.children;
    }

    public FileInfo getData() {
        return this.data;
    }
}

class Tree1 {
    private TreeNode1 root;

    public Tree1(FileInfo rootData) {
        root = new TreeNode1(rootData);
    }

    public TreeNode1 getRoot() {
        return root;
    }
    /**
     * Displays the contents of a directory and calculates the total disk space.
     *
     * @param directoryPath The path of the directory to display.
     */

    public void displayDirectoryContents(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory: " + directory.getAbsolutePath());

            File[] files = directory.listFiles();
            if (files != null) {
                long totalDiskSpace = 0;

                for (File file : files) {
                    int type = file.isDirectory() ? 1 : 0;
                    long size = file.length();
                    Date date = new Date(file.lastModified());

                    FileInfo fileInfo = new FileInfo(file.getName(), type, size, date);
                    TreeNode1 fileNode = new TreeNode1(fileInfo);
                    root.addChild(fileNode);

                    totalDiskSpace += size;

                    System.out.println(fileInfo.getName() + "\t" +
                            (fileInfo.getType() == 1 ? "DIR" : "FILE") + "\t" +
                            fileInfo.getSize() + " bytes\t" +
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fileInfo.getDate()));
                }

                System.out.println("Total Disk Space: " + totalDiskSpace + " bytes");
            } else {
                System.out.println("Unable to list directory contents.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}

