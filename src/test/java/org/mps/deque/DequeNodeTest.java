package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing DequeNode.java
 *
 * @author Ignacio Martínez Gallardo
 */

@DisplayName("A node")
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
            nextNode = new DequeNode<>(3, node, nextNode);
            node = new DequeNode<>(2, previousNode, null);
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
    @DisplayName("Instanciamos un nodo como el último de la Deque")
    class TestCasesForLastNodeOfTheDeque {

    }
}
