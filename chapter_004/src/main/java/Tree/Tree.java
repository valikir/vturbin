package tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    public static class Node<E> {
        Node<E> prev;
        List<Node<E>> children;
        E value;

        public E getValue() {
            return value;
        }

        public boolean hasChildren() {
            if (this.children.size() != 0) {
                return true;
            }
            return false;
        }

        public Node(List<Node<E>> children, E value) {
            this.value = value;
            this.children = children;
        }
    }

    Node<E> parent1 = new Node<E>(new ArrayList<>(), (E) "parent");


    private Node<E> searchNode(E value, E childValue) {
        Node prevNode = parent1;
        Node currentNode = parent1;
        Node<E> duplicateCheck = parent1;
        int index = 0;
        int parentNodes = 0;

        while (currentNode.value != value) {
            if (currentNode.children.size() > 1) {
                currentNode.prev = prevNode;
                prevNode = currentNode;
                currentNode = (Tree.Node) currentNode.children.get(index);
            } else if (currentNode.children.size() == 1) {
                currentNode.prev = prevNode;
                prevNode = currentNode;
                index = 0;
                currentNode = (Tree.Node) currentNode.children.get(index);
            } else if (prevNode.children.size() > index + 1) {
                index++;
                currentNode = (Tree.Node) prevNode.children.get(index);
            } else {
                currentNode = prevNode.prev;
                parentNodes++;
                index = parentNodes;
            }
            if (currentNode.children.size() > 1) {
                duplicateCheck = (Tree.Node) currentNode.children.get(index);
            } else if (currentNode.children.size() == 1) {
                duplicateCheck = (Tree.Node) currentNode.children.get(0);
            }
            if (duplicateCheck.value.equals(childValue)) {
                return null;
            }
        }
        return currentNode;
    }

    public boolean isBinary() {
        boolean binary = false;
        Iterator itr = this.iterator();
        while (itr.hasNext()) {
            Node currentNode = (Node) itr.next();
            if (currentNode.children.size() <= 2 || !currentNode.hasChildren()) {
                binary = true;
                continue;
            } else {
                binary = false;
                break;
            }
        }
        return binary;
    }

    @Override
    public boolean add(E parent, Node<E> child) {
        Node<E> addNode = searchNode(parent, child.value);
        if (addNode != null) {
            addNode.children.add(child);
            child.prev = addNode;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        List nodes = new ArrayList<>();
        int index = 0;
        nodes.add(parent1);
        if (parent1.children.size() > 0) {
            for (Node node : parent1.children) {
                nodes.add(node);
                if (parent1.children.get(index).children != null) {
                    Iterator childIterator = parent1.children.get(index).children.iterator();
                    while (childIterator.hasNext()) {
                        nodes.add(childIterator.next());
                    }
                }
                index++;
            }
        }
        return nodes.iterator();
    }
}

