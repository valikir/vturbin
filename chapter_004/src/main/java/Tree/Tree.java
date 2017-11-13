package Tree;


import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    public static class Node<E> {
        Node<E> prev;
        List<Node<E>> children;
        E value;

        public E getValue() {
            return value;
        }

        public Node(List<Node<E>> children, E value){
            this.value = value;
            this.children = children;
        }
    }
    Node<E> parent1 = new Node<E>( new ArrayList<>(), (E) "parent" );


    private Node<E> SearchNode(E value, E childValue) {
        Node PrevNode = parent1;
        Node CurrentNode = parent1;
        Node<E> DuplicateCheck = parent1;
        int index = 0;
        int ParentNodes = 0;

        while (CurrentNode.value != value) {
            if (CurrentNode.children.size() > 1) {
                CurrentNode.prev = PrevNode;
                PrevNode = CurrentNode;
                CurrentNode = (Tree.Node) CurrentNode.children.get( index );
            } else if (CurrentNode.children.size() == 1) {
                CurrentNode.prev = PrevNode;
                PrevNode = CurrentNode;
                index = 0;
                CurrentNode = (Tree.Node) CurrentNode.children.get( index );
            } else if (PrevNode.children.size() > index + 1) {
                index++;
                CurrentNode = (Tree.Node) PrevNode.children.get( index );
            } else {
                CurrentNode = PrevNode.prev;
                ParentNodes++;
                index = ParentNodes;
            }
            if (CurrentNode.children.size() > 1) {
                DuplicateCheck  = (Tree.Node<E>) CurrentNode.children.get( index );
            }
                else if (CurrentNode.children.size() == 1){
                    DuplicateCheck = (Tree.Node<E>) CurrentNode.children.get( 0 );
                }
                if (DuplicateCheck.value.equals( childValue )) {
                    return CurrentNode = null;
            }
        }
        return CurrentNode;
    }


    @Override
    public boolean add(E parent, Node<E> child) {
        Node<E> AddNode = SearchNode( parent, child.value);
       if (AddNode != null && AddNode.value.compareTo( parent )==0) {
           AddNode.children.add( child );
           child.prev = AddNode;
           return true;
       }
        else {
           return false;
       }
    }

    @Override
    public Iterator iterator() {
        List<E> Nodes = new ArrayList<>(  );
        return null;
    }

    public static void main(String[] args){
        Tree tree = new Tree<>();
        tree.add("parent", new Node( new ArrayList<>(),"child" ));
        tree.add("parent", new Node( new ArrayList<>(),"child2" ));
        tree.add("child", new Node( new ArrayList<>(),"child4" ));
        tree.add("child", new Node( new ArrayList<>(),"child4" ));
        tree.add("child2", new Node( new ArrayList<>(),"child5" ));
        tree.add("child2", new Node( new ArrayList<>(),"child6" ));
        tree.add("child2", new Node( new ArrayList<>(),"child7" ));
    }
}

