package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedListDequeTest {

    DoubleEndedQueue<Integer> deque;

    @BeforeEach
    void createDeque(){
        deque = new DoublyLinkedListDeque<>();
    }

    @Test
    void newDequeFirstIsNull(){
        assertEquals(null, deque.first());
    }

    @Test
    void newDequeLastIsNull(){
        assertEquals(null, deque.last());
    }

    @Test
    void newDequeSizeIs0(){
        assertEquals(0, deque.size());
    }

    @Test
    void prependingNodeInEmptyDequeIsTheFirstNode(){
        int item = 1;
        deque.prepend(item);
        assertEquals(item, deque.first());
    }

    @Test
    void prependingNodeInEmptyDequeIsAlsoTheLastNode(){
        int item = 1;
        deque.prepend(item);
        assertEquals(item, deque.last());
    }

    @Test
    void appendingNodeInEmptyDequeIsLastNode(){
        int item = 1;
        deque.append(1);
        assertEquals (item, deque.last());
    }

    @Test
    void appendingNodeInEmptyDequeIsAlsoFirstNode(){
        int item = 1;
        deque.append(item);
        assertEquals (item, deque.first());
    }

    @Test
    void size1DequeFirstEqualsLast(){
        int item = 1;
        deque.prepend(item);
        assertEquals (deque.first(), deque.last());
    }

    @Test
    void prependingANodeInEmptyDequeMakesItHaveSize1(){
        int item = 1;
        deque.prepend(item);
        assertEquals(deque.size(), 1);
    }

    @Test
    void appendingANodeInEmptyDequeMakesItHaveSize1(){
        int item = 1;
        deque.append(item);
        assertEquals(deque.size(), 1);
    }

    @Test
    void prependingNodeInDequeIsFirst() {
        int item1 = 1;
        int item2 = 2;
        deque.prepend(item1);
        deque.prepend(item2);
        assertEquals(item2, deque.first());
    }

}