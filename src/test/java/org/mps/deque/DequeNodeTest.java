package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing DequeNode.java
 *
 * @author Ignacio Martínez Gallardo
 */

class DequeNodeTest {
    DequeNode<Integer> node, previousNode, nextNode;

    @Nested
    @DisplayName("Instanciamos un nodo que como el primero de la Deque")
    class TestCasesForInitialNodeOfTheDeque {
        @BeforeEach
        void setup() {
            previousNode = new DequeNode<>(1,null,null);
            node = new DequeNode<>(2, null, null);
            nextNode = new DequeNode<>(3, null, null);

            previousNode.setNext(node);
            nextNode.setPrevious(node);
            node.setPrevious(previousNode);
            node.setNext(nextNode);
        }

        @AfterEach
        void shutdown() {
            previousNode = null;
            nextNode = null;
            node = null;
        }

        @Test
        void shouldReturnTheNodeItem() {
            int expectedValue = 1;
            int actualValue = previousNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldSetTheNodeItemTo6() {
            previousNode.setItem(6);
            int expectedValue = 6;
            int actualValue = previousNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldReturnThePreviousNode() {
            assertNull(previousNode.getPrevious());
        }

        @Test
        void shouldReturnTheNextNode() {
            DequeNode<Integer> expectedValue = node;
            DequeNode<Integer> actualValue = previousNode.getNext();

            assertEquals(expectedValue, actualValue);
        }


        @Test
        void shouldReturnTrueToNodeBeingTheFirstNodeOfTheDeque() {
            assertTrue(previousNode.isFirstNode());
        }


        @Test
        void shouldReturnFalseToNodeBeingTheLastNodeOfTheDeque() {
            assertFalse(previousNode.isLastNode());
        }

        @Test
        void shouldReturnFalseToNodeNotBeingATerminalNode() {
            assertFalse(previousNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("Instanciamos un nodo como uno intermedio de la Deque")
    class TestCasesForANodeOfTheDeque {
        @BeforeEach
        void setup() {
            previousNode = new DequeNode<>(4,null,null);
            node = new DequeNode<>(5, null, null);
            nextNode = new DequeNode<>(6, null, null);

            previousNode.setNext(node);
            nextNode.setPrevious(node);
            node.setPrevious(previousNode);
            node.setNext(nextNode);
        }

        @AfterEach
        void shutdown() {
            node = null;
            previousNode = null;
            nextNode = null;
        }

        @Test
        void shouldReturnTheNodeItem() {
            int expectedValue = 5;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldSetTheNodeItemTo10() {
            node.setItem(10);
            int expectedValue = 10;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldReturnThePreviousNode() {
            DequeNode<Integer> expectedValue = previousNode;
            DequeNode<Integer> actualValue = node.getPrevious();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldReturnTheNextNode() {
            DequeNode<Integer> expectedValue = nextNode;
            DequeNode<Integer> actualValue = node.getNext();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldReturnFalseToNodeBeingTheFirstNodeOfTheDeque() {
            assertFalse(node.isFirstNode());
        }

        @Test
        void shouldReturnFalseToNodeBeingTheLastNodeOfTheDeque() {
            assertFalse(node.isLastNode());
        }

        @Test
        void shouldReturnTrueToNodeNotBeingATerminalNode() {
            assertTrue(node.isNotATerminalNode());
        }
    }
    @Nested
    @DisplayName("Instanciamos un nodo como el último de la Deque")
    class TestCasesForLastNodeOfTheDeque {
        @BeforeEach
        void setup() {
            previousNode = new DequeNode<>(6,null,node);
            nextNode = new DequeNode<>(8, node, null);
            node = new DequeNode<>(7, previousNode, nextNode);
        }

        @AfterEach
        void shutdown() {
            node = null;
            previousNode = null;
            nextNode = null;
        }

        @Test
        void shouldReturnTheNodeItem() {
            int expectedValue = 8;
            int actualValue = nextNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldSetTheNodeItemTo1() {
            node.setItem(1);
            int expectedValue = 1;
            int actualValue = nextNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        /*
        @Test
        void shouldReturnThePreviousNode() {
            DequeNode<Integer> expectedValue = node;
            DequeNode<Integer> actualValue = nextNode.getPrevious();

            assertEquals(expectedValue, actualValue);
        }
        */

        @Test
        void shouldReturnNullAsTheNextNode() {
            assertNull(nextNode.getNext());
        }

        @Test
        void shouldReturnTrueToNodeBeingTheFirstNodeOfTheDequeue() {
            assertTrue(nextNode.isFirstNode());
        }

        @Test
        void shouldReturnTrueToNodeBeingTheLastNodeOfTheDequeue() {
            assertTrue(nextNode.isLastNode());
        }

        @Test
        void shouldReturnFalseToNodeNotBeingATerminalNode() {
            assertFalse(nextNode.isNotATerminalNode());
        }
    }
}
