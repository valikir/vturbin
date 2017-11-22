package tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void addThreeNodesOnLeftSideOneRightShowThreeLeftOneRight() {
        BinarySearchTree searchTree = new BinarySearchTree();
        searchTree.add(34);
        searchTree.add(33);
        searchTree.add(32);
        searchTree.add(35);
        int root = searchTree.root.data;
        assertThat(root, is(34));
        int left = searchTree.root.left.data;
        assertThat(left, is(33));
        int leftLeft = searchTree.root.left.left.data;
        assertThat(leftLeft, is(32));
        int right = searchTree.root.right.data;
        assertThat(right, is(35));
    }
}