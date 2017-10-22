package list;


public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    boolean hasCycle(Node node) {
        Object[] nodes = new Object[50];
        int i = 1;
        nodes[0] = node.value;
        Node n = node.next;
        while (n != null) {
            nodes[i] = n.value;
            for (int index = 0; index< i-1; index++) {
                if (nodes[i].equals( nodes[index] ) && nodes[i] != null ) {
                    return true;
                }
            }
                n = n.next;
                i++;
        }
        return false;
    }
}
