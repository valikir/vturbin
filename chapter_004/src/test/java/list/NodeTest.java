package list;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeTest {

    @Test
    public void FourNodesCheckNodeFirstAndLastLink(){
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = two;

        boolean hasCyc = first.hasCycle(two);
        assertThat(hasCyc, is(true));

        boolean hasCyc2 = first.hasCycle(four);
        assertThat(hasCyc2, is(true));
    }

    @Test
    public void FourNodesCheckLastNodePointToNull(){
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        boolean hasCyc = first.hasCycle(two);
        assertThat(hasCyc, is(false));
    }

}