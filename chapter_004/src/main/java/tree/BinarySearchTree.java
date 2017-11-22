package tree;

public class BinarySearchTree<E> {

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public static class Node<E> {
        int data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = (Integer) data;
            left = null;
            right = null;
        }
    }

    public boolean add(E e) {
        boolean added;
        Node newNode = new Node(e);
        if (root == null) {
            root = newNode;
            added = true;
            return added;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if ((Integer) e < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    added = true;
                    return added;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    added = true;
                    return added;
                }
            }
        }
    }
}
