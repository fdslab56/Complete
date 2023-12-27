import java.util.*;

/**
 * Main class representing a tree structure, providing a menu-driven interface
 * to interact with the tree.
 */
public class Main {

    /**
     * The main method to execute the tree operations via a menu-driven interface.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value for the root node: ");

        String rootValue = scanner.nextLine();
        MyTree<String> tree = new MyTree<>(rootValue);

        System.out.println("Tree Structure:");
        tree.display();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a child node");
            System.out.println("2. List leaves of the tree");
            System.out.println("3. List internal nodes of the tree");
            System.out.println("4. List of edges");
            System.out.println("5. Find path for a node");
            System.out.println("6. Find depth of a node");
            System.out.println("7. Find height of the tree");
            System.out.println("8. Display the tree");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addChildNode(tree, scanner);
                    break;
                case 2:
                    listLeaves(tree);
                    break;
                case 3:
                    listInternalNodes(tree);
                    break;
                case 4:
                    listEdges(tree);
                    break;
                case 5:
                    findPath(tree, scanner);
                    break;
                case 6:
                    findDepth(tree, scanner);
                    break;
                case 7:
                    findHeight(tree);
                    break;
                case 8:
                    tree.display();
                    break;
                case 9:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a child node to the tree under the specified parent node value.
     *
     * @param tree    The tree where the node will be added.
     * @param scanner Scanner object for user input.
     */
    public static void addChildNode(MyTree<String> tree, Scanner scanner) {
        System.out.print("Enter the value of the parent node to add a child: ");

        scanner.nextLine();

        String parentValue = scanner.nextLine();

        TreeNode<String> parentNode = findNode(tree.root, parentValue);

        if (parentNode != null) {
            System.out.print("Enter the value of the child node: ");
            String childValue = scanner.nextLine();
            TreeNode<String> childNode = new TreeNode<>(childValue);
            parentNode.addChild(childNode);
            System.out.println("Node " + childValue + " added as a child of Node " + parentValue);
            System.out.println("Updated Tree Structure:");
            tree.display();
        } else {
            System.out.println("Parent node not found. Node not added.");
        }
    }

    /**
     * Lists all the leaf nodes in the tree.
     *
     * @param tree The tree to find leaf nodes from.
     */
    public static void listLeaves(MyTree<String> tree) {
        List<TreeNode<String>> leaves = tree.getLeaves();

        System.out.println("List of Leaves:");
        for (TreeNode<String> leaf : leaves) {
            System.out.println(leaf.data);
        }
    }

    /**
     * Lists all the internal nodes in the tree.
     *
     * @param tree The tree to find internal nodes from.
     */
    public static void listInternalNodes(MyTree<String> tree) {
        List<TreeNode<String>> internalNodes = tree.getInternalNodes();
        System.out.println("List of Internal Nodes:");
        for (TreeNode<String> internalNode : internalNodes) {
            System.out.println(internalNode.data);
        }
    }

    /**
     * Lists all the edges in the tree.
     *
     * @param tree The tree to find edges from.
     */
    public static void listEdges(MyTree<String> tree) {
        List<String> edges = tree.getEdges();
        System.out.println("List of Edges:");
        for (String edge : edges) {
            System.out.println(edge);
        }
    }

    /**
     * Finds the path from the root node to the specified node value in the tree.
     *
     * @param tree    The tree to search for the node.
     * @param scanner Scanner object for user input.
     */
    public static void findPath(MyTree<String> tree, Scanner scanner) {
        System.out.print("Enter the value of the node to find its path: ");
        String targetValue = scanner.next(); // Assuming node values are strings
        TreeNode<String> targetNode = findNode(tree.root, targetValue);

        if (targetNode != null) {
            List<String> path = tree.getPath(targetNode);
            System.out.println("Path for Node " + targetValue + ": " + path);
        } else {
            System.out.println("Node not found in the tree.");
        }
    }

    /**
     * Finds the depth of the specified node value in the tree.
     *
     * @param tree    The tree to search for the node.
     * @param scanner Scanner object for user input.
     */
    public static void findDepth(MyTree<String> tree, Scanner scanner) {
        System.out.print("Enter the value of the node to find its depth: ");
        String targetValue = scanner.next(); // Assuming node values are strings
        TreeNode<String> targetNode = findNode(tree.root, targetValue);

        if (targetNode != null) {
            int depth = tree.getDepth(targetNode);
            System.out.println("Depth of Node " + targetValue + ": " + depth);
        } else {
            System.out.println("Node not found in the tree.");
        }
    }

    /**
     * Finds the height of the tree.
     *
     * @param tree The tree to find the height from.
     */
    public static void findHeight(MyTree<String> tree) {
        int height = tree.getHeight();
        System.out.println("Height of the Tree: " + height);
    }

    /**
     * Finds a specific node in the tree based on the node's value.
     *
     * @param node  The starting node to begin the search.
     * @param value The value to search for in the tree nodes.
     * @return The node if found, otherwise null.
     */
    public static TreeNode<String> findNode(TreeNode<String> node, String value) {
        if (node.data.equals(value)) {
            return node;
        }

        for (TreeNode<String> child : node.children) {
            TreeNode<String> result = findNode(child, value);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

}
