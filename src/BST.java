import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchTree(this.root, val);
    }

    private boolean searchTree(BSTNode node, int val) {
        if (node == null) {
            return false; // If the node is null return false - base case
        }
        // But if the val matches with the node's value, it's true so
        else if (node.getVal() == val) {
            return true;
        }
        // Yet if val is less than, search the left node
        else if(val < node.getVal()) {
            return searchTree(node.getLeft(), val);
        }
        // Otherwise search the right
        else {
            return searchTree(node.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> output = new ArrayList<>();
        inOrder(this.root, output);
        return output;
    }

    private void inOrder(BSTNode node, ArrayList<BSTNode> output) {
        // If not null, check left tree
        if (node != null) {
            inOrder(node.getLeft(), output);
            // add the node to the result, next check the right side
            output.add(node);
            inOrder(node.getRight(), output);
        }
    }
    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> output = new ArrayList<>();
        preOrder(this.root, output);
        return output;
    }

    private void preOrder(BSTNode node, ArrayList<BSTNode> output) {
        // If the not is not null add to result
        if (node != null) {
            output.add(node);
            // traverse both left and right nodes within the subtree
            preOrder(node.getLeft(), output);
            preOrder(node.getRight(), output);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> output = new ArrayList<>();
        postOrder(this.root, output);
        return output;
    }

    private void postOrder(BSTNode node, ArrayList<BSTNode> output) {
        // Check the left and right subtrees
        if(node != null) {
            postOrder(node.getLeft(), output);
            postOrder(node.getRight(), output);
            // add to output
            output.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        this.root = inserter(this.root, val);
    }

    private BSTNode inserter(BSTNode node, int val) {
        // The new node value is inserted
        if (node == null) {
            node = new BSTNode(val);
        }
        // If val is less than the value, set to left subtree
        else if(val < node.getVal()) {
            node.setLeft(inserter(node.getLeft(), val));
        }
        // If val is greater than the node's value, set to right subtree
        else if (val > node.getVal()) {
            node.setRight(inserter(node.getRight(), val));
        }
        // Return node if val equals the current value
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
