package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing DequeNode.java
 *
 * @author Ignacio Martínez Gallardo
 */

@DisplayName("Un nodo")
class DequeNodeTest {
    DequeNode<Integer> node, previousNode, nextNode;

    @Nested
    @DisplayName("se instancia como el primero de la Deque")
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
        @DisplayName("si pedimos su valor devuelve 1")
        void shouldReturn1AsThePreviousNodeItem() {
            int expectedValue = 1;
            int actualValue = previousNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si cambiamos su valor a 6 se actualiza correctamente")
        void shouldSetThePreviousNodeItemTo6() {
            previousNode.setItem(6);
            int expectedValue = 6;
            int actualValue = previousNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si pedimos su nodo anterior devuelve null")
        void shouldReturnNullAsThePreviousNode() {
            assertNull(previousNode.getPrevious());
        }

        @Test
        @DisplayName("si pedimos su nodo posterior devuelve dicho nodo")
        void shouldReturnNodeAsTheNextNode() {
            DequeNode<Integer> expectedValue = node;
            DequeNode<Integer> actualValue = previousNode.getNext();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si comprobamos que es el primero devuelve true")
        void shouldReturnTrueToPreviousNodeBeingTheFirstNodeOfTheDeque() {
            assertTrue(previousNode.isFirstNode());
        }

        @Test
        @DisplayName("si comprobamos que es el último devuelve false")
        void shouldReturnFalseToPreviousNodeBeingTheLastNodeOfTheDeque() {
            assertFalse(previousNode.isLastNode());
        }

        @Test
        @DisplayName("si comprobamos que es uno intermedio devuelve false")
        void shouldReturnFalseToPreviousNodeNotBeingATerminalNode() {
            assertFalse(previousNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("se instancia como uno intermedio de la Deque")
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
        @DisplayName("si pedimos su valor devuelve 5")
        void shouldReturn5AsTheNodeItem() {
            int expectedValue = 5;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si cambiamos su valor a 10 se actualiza correctamente")
        void shouldSetTheNodeItemTo10() {
            node.setItem(10);
            int expectedValue = 10;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si pedimos su nodo anterior devuelve dicho nodo")
        void shouldReturnPreviousNodeAsThePreviousNode() {
            DequeNode<Integer> expectedValue = previousNode;
            DequeNode<Integer> actualValue = node.getPrevious();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si pedimos su nodo posterior devuelve dicho nodo")
        void shouldReturnNextNodeAsTheNextNode() {
            DequeNode<Integer> expectedValue = nextNode;
            DequeNode<Integer> actualValue = node.getNext();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si comprobamos que es el primero devuelve false")
        void shouldReturnFalseToNodeBeingTheFirstNodeOfTheDeque() {
            assertFalse(node.isFirstNode());
        }

        @Test
        @DisplayName("si comprobamos que es el último devuelve false")
        void shouldReturnFalseToNodeBeingTheLastNodeOfTheDeque() {
            assertFalse(node.isLastNode());
        }

        @Test
        @DisplayName("si comprobamos que es uno intermedio devuelve true")
        void shouldReturnTrueToNodeNotBeingATerminalNode() {
            assertTrue(node.isNotATerminalNode());
        }
    }
    @Nested
    @DisplayName("se instancia como el último de la Deque")
    class TestCasesForLastNodeOfTheDeque {
        @BeforeEach
        void setup() {
            previousNode = new DequeNode<>(7,null,null);
            node = new DequeNode<>(8, null, null);
            nextNode = new DequeNode<>(9, null, null);

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
        @DisplayName("si pedimos su valor devuelve 9")
        void shouldReturn9AsTheNextNodeItem() {
            int expectedValue = 9;
            int actualValue = nextNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si cambiamos su valor a 1 se actualiza correctamente")
        void shouldSetTheNextNodeItemTo1() {
            nextNode.setItem(1);
            int expectedValue = 1;
            int actualValue = nextNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si pedimos su nodo anterior devuelve dicho nodo")
        void shouldReturnNodeAsThePreviousNode() {
            DequeNode<Integer> expectedValue = node;
            DequeNode<Integer> actualValue = nextNode.getPrevious();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("si pedimos su nodo posterior devuelve null")
        void shouldReturnNullAsTheNextNode() {
            assertNull(nextNode.getNext());
        }

        @Test
        @DisplayName("si comprobamos que es el primero devuelve false")
        void shouldReturnFalseToNextNodeBeingTheFirstNodeOfTheDeque() {
            assertFalse(nextNode.isFirstNode());
        }

        @Test
        @DisplayName("si comprobamos que es el último devuelve true")
        void shouldReturnTrueToNextNodeBeingTheLastNodeOfTheDeque() {
            assertTrue(nextNode.isLastNode());
        }

        @Test
        @DisplayName("si comprobamos que es uno intermedio devuelve false")
        void shouldReturnFalseToNextNodeNotBeingATerminalNode() {
            assertFalse(nextNode.isNotATerminalNode());
        }
    }
}
