package list;


public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
    }

    boolean hasCycle(Node node){
       int nodeRepCount=0;
        Node n = next;
       while (nodeRepCount!= 2) {
           n = n.next;
           if (n != null && node.value == n.value){
               nodeRepCount++;
           }
           if (n == null){
               return false;
           }
       }
        return true;
    }
}
