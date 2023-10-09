package DataStructures.BinarySearchTree;

public class BinarySearchTree {

    // CREATED CLASS VARIABLE (ROOT) AND NODE CLASS HERE//
    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }





    // WRITTEN INSERT METHOD HERE //
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }




    // WRITTEN CONTAINS METHOD HERE //
    public boolean contains(int value){
        Node temp = root;
        while(temp!=null){
            if(value<temp.value){
                temp = temp.left;
            }else if(value>temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;
    }
    public void preorder() {
        preorder(root);
    }
    void preorder(Node node) {
        if (node == null)
            return;

        // traverse the root node
        System.out.print(node.value + "->");
        // traverse the left child
        preorder(node.left);
        // traverse the right child
        preorder(node.right);
    }

    public void inorder() {
        inorder(root);
    }
    void inorder(Node node) {
        if (node == null)
            return;
        // traverse the left child
        inorder(node.left);
        // traverse the root node
        System.out.print(node.value+ "->");
        // traverse the right child
        inorder(node.right);
    }

    public void postorder() {
        postorder(root);
    }

    void postorder(Node node) {
        if (node == null)
            return;
        // traverse the left child
        postorder(node.left);
        // traverse the right child
        postorder(node.right);
        // traverse the root node
        System.out.print(node.value + "->");
    }
}




