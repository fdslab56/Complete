import java.util.*;
import java.util.Scanner;


public class Main {

    /**
 * Main class to interact with and demonstrate the functionality of the Tree data structure.
 */// 
    public static void main(String[] args) {
        



    /**
     * The main method to execute the program.
     *
     * @param args The command-line arguments 
     */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the root node data: ");
        String rootData = scanner.nextLine();

        Tree<String> tree = new Tree<>(rootData);
        

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Child Node");
            System.out.println("2. Display Tree");
            System.out.println("3. Siblings of a Node");
            System.out.println("4. List Leaves of the Tree");
            System.out.println("5. List Internal Nodes of the Tree");
            System.out.println("6. List of Edges");
            System.out.println("7. Path for a Given Node");
            System.out.println("8. Depth of a Node");
            System.out.println("9. Height of the Tree");
            System.out.println("10. Subtree Rooted at a Given Node");
            System.out.println("11. Tree with depth");
            System.out.println("12. Infix Expression");
            System.out.println("13. Tree with Edges");
            System.out.println("14. Directory");

            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            
            switch (choice) {
                
                case 2:
                    System.out.println("Tree Structure:");
                    displayTree(tree.getRoot(), 0);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter node data: ");
                    String siblingData = scanner.nextLine();
                    TreeNode<String> siblingNode = findNode(tree.getRoot(), siblingData);
                    if (siblingNode != null) {
                        List<TreeNode<String>> siblings = tree.getSiblings(siblingNode);
                        System.out.println("Siblings of " + siblingData + ":");
                        for (TreeNode<String> sibling : siblings) {
                            System.out.println(sibling.getData());
                        }
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 4:
                    List<TreeNode<String>> leaves = tree.getLeaves(tree.getRoot());
                    System.out.println("Leaves of the Tree:");
                    for (TreeNode<String> leaf : leaves) {
                        System.out.println(leaf.getData());
                    }
                    break;
                case 5:
                    List<TreeNode<String>> internalNodes = tree.getInternalNodes(tree.getRoot());
                    System.out.println("Internal Nodes of the Tree:");
                    for (TreeNode<String> internalNode : internalNodes) {
                        System.out.println(internalNode.getData());
                    }
                    break;
                case 6:
                    List<String> edges = tree.getEdges(tree.getRoot());
                    System.out.println("Edges of the Tree:");
                    for (String edge : edges) {
                        System.out.println(edge);
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.print("Enter node data: ");
                    String pathNodeData = scanner.nextLine();
                    TreeNode<String> pathNode = findNode(tree.getRoot(), pathNodeData);
                    if (pathNode != null) {
                        List<String> path = tree.getPath(pathNode);
                        System.out.println("Path for " + pathNodeData + ":");
                        for (String nodeData : path) {
                            System.out.print(nodeData + "->");
                        }
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 8:
                    scanner.nextLine();
                    System.out.print("Enter node data: ");
                    String depthNodeData = scanner.nextLine();
                    TreeNode<String> depthNode = findNode(tree.getRoot(), depthNodeData);
                    if (depthNode != null) {
                        int depth = tree.getDepth(depthNode);
                        System.out.println("Depth of " + depthNodeData + ": " + depth);
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 9:
                    int height = tree.getHeight();
                    System.out.println("Height of the Tree: " + height);
                    break;
                case 10:
                    scanner.nextLine();
                    System.out.print("Enter node data: ");
                    String subtreeRootData = scanner.nextLine();
                    TreeNode<String> subtreeRoot = findNode(tree.getRoot(), subtreeRootData);
                    if (subtreeRoot != null) {
                        Tree<String> subtree = tree.getSubtree(subtreeRoot);
                        System.out.println("Subtree rooted at " + subtreeRootData + ":");
                        displayTree(subtree.getRoot(), 0);
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 11: 
                    System.out.println("Tree Structure:");
                    displayTreeS(tree.getRoot(), "");
                    break;
                case 12:
                    System.out.println("Infix Expression: " + tree.getInfixExpression());
                    
                    break;
                case 1:
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter the data of the target node: ");
                    String targetData = scanner.nextLine();
                    System.out.print("Enter the depth at which to add the child: ");
                    int targetDepth = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                
                    System.out.print("Enter the data for the new child node: ");
                    String newChildData = scanner.nextLine();
                
                    TreeNode<String> targetNode = findNode(tree.getRoot(), targetData);
                    if (targetNode != null) {
                        TreeNode<String> newChildNode = new TreeNode<>(newChildData);
                        tree.addChildd(targetNode.getData(), targetDepth, newChildNode);
                        System.out.println("Child node added successfully.");
                    } else {
                        System.out.println("Target node not found.");
                    }
                    break;
                case 13:
                    System.out.println("Tree Structure with Edges:");
                    displayTreeWithEdges(tree.getRoot());
                    break;

    
                case 14:
                     FileInfo rootFileInfo = new FileInfo("Root", 1, 0, new Date());
                     Tree1 fileTree = new Tree1(rootFileInfo);
                     System.out.println("Enter directory path: ");
                     scanner.nextLine();
                     String x=scanner.nextLine();

                     fileTree.displayDirectoryContents(x);
    
                

                    
            
                case 0:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                
                
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    /**
     * Helper method to find a node with the specified data in the tree.
     *
     * @param current The current node being examined.
     * @param targetData The data of the node to find.
     * @return The node with the specified data or null if not found.
     */

    private static TreeNode<String> findNode(TreeNode<String> current, String targetData) {
        if (current.getData().equals(targetData)) {
            return current;
        }
        for (TreeNode<String> child : current.getChildren()) {
            TreeNode<String> result = findNode(child, targetData);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
    
    
        
    


    /**
     * Helper method to display the tree structure.
     *
     * @param node The current node to display.
     * @param depth The depth of the current node in the tree.
     */

     private static void displayTreeS(TreeNode<String> node, String nodeNumber) {
        // Display the root node without a number
        if (nodeNumber.isEmpty()) {
            System.out.println(node.getData());
        } else {
            // Display non-root nodes with the numbering system
            StringBuilder indentation = new StringBuilder();
            for (int i = 0; i < nodeNumber.length(); i++) {
                indentation.append("  ");
            }
            System.out.println(indentation + nodeNumber + " " + node.getData());
        }
    
        for (int i = 0; i < node.getChildren().size(); i++) {
            String childNumber = nodeNumber.isEmpty() ? String.valueOf(i + 1) : nodeNumber + "." + (i + 1);
            TreeNode<String> child = node.getChildren().get(i);
            displayTreeS(child, childNumber);
        }
    }
    private static void displayTree(TreeNode<String> node, int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  ");
        }
        System.out.println(indentation + "- " + node.getData());
        for (TreeNode<String> child : node.getChildren()) {
            displayTree(child, depth + 1);
        }
    }
/**
 * Displays the tree structure with edges, starting from the given node.
 *
 * @param node The root node of the tree to be displayed.
 */
private static void displayTreeWithEdges(TreeNode<String> node) {
    displayTreeWithEdgesRecursive(node, "");
}
/**
 * Recursively displays the tree structure with edges for the given node and prefix.
 * This method is called by {@link #displayTreeWithEdges(TreeNode)}.
 *
 * @param node   The current node being processed.
 * @param prefix The prefix to be added for the indentation.
 */
private static void displayTreeWithEdgesRecursive(TreeNode<String> node, String prefix) {
    if (node == null) {
        return;
    }

    List<TreeNode<String>> children = node.getChildren();
    int numChildren = children.size();

    for (int i = 0; i < numChildren - 1; i++) {
        TreeNode<String> child = children.get(i);
        displayTreeWithEdgesRecursive(child, prefix + "│   ");
    }

    if (numChildren > 0) {
        TreeNode<String> lastChild = children.get(numChildren - 1);
        displayTreeWithEdgesRecursive(lastChild, prefix + "    ");
    }

    System.out.print(prefix);

    if (numChildren > 0) {
        System.out.print("└── ");
    } else {
        System.out.print("┌── ");
    }

    System.out.println(node.getData());
}
    

    
}



