package list;

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
       // four.next = first;

        boolean hasCyc = four.hasCycle();
        assertThat(hasCyc, is(false));

        boolean hasCyc2 = first.hasCycle();
        assertThat(hasCyc2, is(true));
    }

}