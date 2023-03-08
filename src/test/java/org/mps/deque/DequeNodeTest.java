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
            node = new DequeNode<>(1, null, null);
        }

        @AfterEach
        void shutdown() {
            node = null;
        }

        @Test
        void shouldReturnTheNodeItem() {
            int expectedValue = 1;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldSetTheNodeItemTo2() {
            node.setItem(2);
            assertEquals(2, node.getItem());
        }

        @Test
        void shouldReturnThePreviousNode() {
            assertNull(node.getPrevious());
        }

        @Test
        void shouldReturnTheNextNode() {
            assertNull(node.getNext());
        }

        @Test
        void shouldReturnTrueToNodeBeingTheFirstNodeOfTheDequeue() {
            assertTrue(node.isFirstNode());
        }

        @Test
        void shouldReturnTrueToNodeBeingTheLastNodeOfTheDequeue() {
            assertTrue(node.isLastNode());
        }

        @Test
        void shouldReturnFalseToNodeNotBeingATerminalNode() {
            assertFalse(node.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("Instanciamos un nodo como uno intermedio de la Deque")
    class TestCasesForNodeOfTheDeque {
        @BeforeEach
        void setup() {
            previousNode = new DequeNode<>(1,null,null);
            nextNode = new DequeNode<>(3, node, null);
            node = new DequeNode<>(2, previousNode, nextNode);
        }

        @AfterEach
        void shutdown() {
            node = null;
            previousNode = null;
            nextNode = null;
        }

        @Test
        void shouldReturnTheNodeItem() {
            int expectedValue = 2;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        void shouldSetTheNodeItemTo5() {
            node.setItem(5);
            assertEquals(5, node.getItem());
        }

        @Test
        void shouldReturnThePreviousNode() {
            assertEquals(previousNode, node.getPrevious());
        }

        @Test
        void shouldReturnTheNextNode() {
            assertEquals(nextNode, node.getNext());
        }

        @Test
        void shouldReturnFalseToNodeBeingTheFirstNodeOfTheDequeue() {
            assertFalse(node.isFirstNode());
        }

        @Test
        void shouldReturnFalseToNodeBeingTheLastNodeOfTheDequeue() {
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
            previousNode = new DequeNode<>(6,null,null);
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
