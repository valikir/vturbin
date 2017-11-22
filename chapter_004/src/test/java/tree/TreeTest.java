package tree;

import list.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {

        @Test
    public void whenAddSevenElementsDismissOneChild4() {
            Tree tree = new Tree<>();
            tree.add("parent", new Tree.Node(new ArrayList<>(), "child"));
            tree.add("parent", new Tree.Node(new ArrayList<>(), "child2"));
            tree.add("child", new Tree.Node(new ArrayList<>(), "child4"));
            tree.add("child", new Tree.Node(new ArrayList<>(), "child4"));
            tree.add("child2", new Tree.Node(new ArrayList<>(), "child5"));
            tree.add("child2", new Tree.Node(new ArrayList<>(), "child6"));
            tree.add("child2", new Tree.Node(new ArrayList<>(), "child7"));
            Iterator itr = tree.iterator();
            Tree.Node node = (Tree.Node) itr.next();
            System.out.println(node.getValue());
            Tree.Node node2 = (Tree.Node) itr.next();
            System.out.println(node2.getValue());
            Tree.Node node3 = (Tree.Node) itr.next();
            System.out.println(node3.getValue());
            Tree.Node node4 = (Tree.Node) itr.next();
            System.out.println(node4.getValue());
            Tree.Node node5 = (Tree.Node) itr.next();
            System.out.println(node5.getValue());
            Tree.Node node6 = (Tree.Node) itr.next();
            System.out.println(node6.getValue());
            Tree.Node node7 = (Tree.Node) itr.next();
            System.out.println(node7.getValue());
    }

    @Test
    public void whenNonBinaryTreeThenIsBinaryFalse() {
        Tree tree = new Tree<>();
        tree.add("parent", new Tree.Node( new ArrayList<>(), "child" ));
        tree.add("parent", new Tree.Node( new ArrayList<>(), "child2" ));
        tree.add("child", new Tree.Node( new ArrayList<>(), "child4" ));
        tree.add("child", new Tree.Node( new ArrayList<>(), "child4" ));
        tree.add("child2", new Tree.Node( new ArrayList<>(), "child5" ));
        tree.add("child2", new Tree.Node( new ArrayList<>(), "child6" ));
        tree.add("child2", new Tree.Node( new ArrayList<>(), "child7" ));
        boolean isBinary = tree.isBinary();
        assertThat(isBinary, is(false));
    }

    @Test
    public void whenBinaryTreeThenIsBinaryTrue() {
        Tree tree = new Tree<>();
        tree.add("parent", new Tree.Node( new ArrayList<>(), "child" ));
        tree.add("parent", new Tree.Node( new ArrayList<>(), "child2" ));
        tree.add("child", new Tree.Node( new ArrayList<>(), "child3" ));
        tree.add("child", new Tree.Node( new ArrayList<>(), "child4" ));
        tree.add("child2", new Tree.Node( new ArrayList<>(), "child5" ));
        tree.add("child2", new Tree.Node( new ArrayList<>(), "child6" ));
        boolean isBinary = tree.isBinary();
        assertThat(isBinary, is(true));
    }
}