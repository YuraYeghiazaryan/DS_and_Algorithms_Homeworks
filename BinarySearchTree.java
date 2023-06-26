package trees;

public class BinarySearchTree {
    private Node root;

    class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public void insert(int value){
        add(root, value);
    }

    private void add(Node node, int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        if(value < node.value){
            if(node.left == null){
                node.left = new Node(value);
            } else {
                add(node.left, value);
            }
        } else {
            if(node.right == null){
                node.right = new Node(value);
            } else {
                add(node.right, value);
            }
        }


    }

    public void printTreeInOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node.left != null){
            inOrder(node.left);
        }
        System.out.println(node.value);
        if(node.right != null){
            inOrder(node.right);
        }
    }

    public void printTreePostOrder() {
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public void printTreePreOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public Node getMax() {
        return searchMax(root);
    }

    private Node searchMax(Node node) {
        if(node == null) {
            return null;
        }
        if(node.right == null) {
            return node;
        }
        return searchMax(node.right);
    }

    public Node getMin() {
        return searchMin(root);
    }

    private Node searchMin(Node node) {
        if(node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return searchMin(node.left);

    }

    public void delete(int value){
        del(root, value);
    }

    private Node del(Node node, int value){
        if(node == null){
            return null;
        } else if (value < node.value) {
            node.left = del(node.left, value);
        } else if (value > node.value) {
            node.right = del(node.right, value);
        } else {
            if(node.left == null || node.right == null) {
                node = (node.left == null) ? node.right:node.left;
            } else {
                Node maxInLeft = searchMax(node.left);
                node.value = maxInLeft.value;
                del(node.left, maxInLeft.value);
            // or
//                Node minInRight = searchMin(node.right);
//                node.value = minInRight.value;
//                del(node.right, minInRight.value);
            }

        }
    return node;
    }

}
