public class AVLTree {
    Node root;
    class Node{
        int value;
        int height = 0;
        Node left = null;
        Node right = null;
        Node(int value) {this.value = value;}
    }

    private void updateHeight(Node node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.right) - getHeight(node.left);
    }

    private void balance(Node node) {
        int balance = getBalance(node);
        if(balance == -2) {
            if(getBalance(node.left) == 1){
                leftRotate(node.left);
            }
            rightRotate(node);
        } else if (balance == 2) {
            if(getBalance(node.right) == -1) {
                rightRotate(node.right);
            }
            leftRotate(node);
        }
    }

    public void insert(int value) {
        add(root, value);
    }

    private void add(Node node, int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        if(value < node.value) {
            if(node.left == null) {
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
        updateHeight(node);
        balance(node);
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
        if(node != null) {
            updateHeight(node);
            balance(node);
        }
        return node;
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

    private void swap(Node a, Node b) {
        int aValue = a.value;
        a.value = b.value;
        b.value = aValue;
    }

    private void rightRotate(Node node) {
        swap(node, node.left);
        Node buffer = node.right;
        node.right = node.left;
        node.left = node.right.left;
        node.right.left = node.right.right;
        node.right.right = buffer;

        updateHeight(node.right);
        updateHeight(node);

    }

    private void leftRotate(Node node) {
        swap(node, node.right);
        Node buffer = node.left;
        node.left = node.right;
        node.right = node.left.right;
        node.left.right = node.left.left;
        node.left.left = buffer;
    }



}
