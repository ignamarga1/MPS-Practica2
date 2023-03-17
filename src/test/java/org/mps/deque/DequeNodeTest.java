package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing DequeNode.java
 *
 * @author Ignacio Martínez Gallardo
 */

/* Casos de prueba
*   1. Comprueba que el valor del nodo es 1
*   2. Comprueba que al cambiar el valor del nodo a 6 este se actualiza correctamente
*   3. Comprueba que al pedir el nodo anterior devuelve null
*   4. Comprueba que al pedir el nodo posterior devuelve node
*   5. Comprueba si es el primero, y como lo es se devuelve true
*   6. Comprueba si es el último, y como no lo es se devuelve false
*   7. Comprueba si no es un nodo terminal, y como no lo es se devuelve false
*
*   8. Comprueba que el valor del nodo es 5
*   9. Comprueba que al cambiar el valor del nodo a 10 este se actualiza correctamente
*   10. Comprueba que al pedir el nodo anterior devuelve previousNode
*   11. Comprueba que al pedir el nodo posterior devuelve nextNode
*   12. Comprueba si es el primero, y como no lo es se devuelve false
*   13. Comprueba si es el último, y como no lo es se devuelve false
*   14. Comprueba si no es un nodo terminal, y como lo es se devuelve true
*
*   15. Comprueba que el valor del nodo es 9
*   16. Comprueba que al cambiar el valor del nodo a 1 este se actualiza correctamente
*   17. Comprueba que al pedir el nodo anterior devuelve node
*   18. Comprueba que al pedir el nodo posterior devuelve null
*   19. Comprueba si es el primero, y como no lo es se devuelve false
*   20. Comprueba si es el último, y como lo es se devuelve true
*   21. Comprueba si no es un nodo terminal, y como no lo es se devuelve false
* */

@DisplayName("Dado un nodo")
class DequeNodeTest {
    DequeNode<Integer> node, previousNode, nextNode;

    @Nested
    @DisplayName("cuando se instancia como el primero de la Deque")
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
        @DisplayName("cuando pedimos su valor, el valor correcto")
        void shouldReturn1AsThePreviousNodeItem() {
            int expectedValue = 1;
            int actualValue = previousNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando cambiamos su valor, se actualiza correctamente")
        void shouldSetThePreviousNodeItemTo6() {
            previousNode.setItem(6);
            int expectedValue = 6;
            int actualValue = previousNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando pedimos su nodo anterior, obtenemos el nodo correcto")
        void shouldReturnNullAsThePreviousNode() {
            assertNull(previousNode.getPrevious());
        }

        @Test
        @DisplayName("cuando pedimos su nodo posterior, obtenemos el nodo correcto")
        void shouldReturnNodeAsTheNextNode() {
            DequeNode<Integer> expectedValue = node;
            DequeNode<Integer> actualValue = previousNode.getNext();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando comprobamos si es el primero, es verdadero")
        void shouldReturnTrueToPreviousNodeBeingTheFirstNodeOfTheDeque() {
            assertTrue(previousNode.isFirstNode());
        }

        @Test
        @DisplayName("cuando comprobamos si es el último, es falso")
        void shouldReturnFalseToPreviousNodeBeingTheLastNodeOfTheDeque() {
            assertFalse(previousNode.isLastNode());
        }

        @Test
        @DisplayName("cuando comprobamos si no es uno terminal, es falso")
        void shouldReturnFalseToPreviousNodeNotBeingATerminalNode() {
            assertFalse(previousNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("cuando se instancia como uno intermedio de la Deque")
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
        @DisplayName("cuando pedimos su valor, obtenemos el valor correcto")
        void shouldReturn5AsTheNodeItem() {
            int expectedValue = 5;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando cambiamos su valor, se actualiza correctamente")
        void shouldSetTheNodeItemTo10() {
            node.setItem(10);
            int expectedValue = 10;
            int actualValue = node.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando pedimos su nodo anterior, obtenemos el nodo correcto")
        void shouldReturnPreviousNodeAsThePreviousNode() {
            DequeNode<Integer> expectedValue = previousNode;
            DequeNode<Integer> actualValue = node.getPrevious();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando pedimos su nodo posterior, obtenemos el nodo correcto")
        void shouldReturnNextNodeAsTheNextNode() {
            DequeNode<Integer> expectedValue = nextNode;
            DequeNode<Integer> actualValue = node.getNext();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando comprobamos si es el primero, es falso")
        void shouldReturnFalseToNodeBeingTheFirstNodeOfTheDeque() {
            assertFalse(node.isFirstNode());
        }

        @Test
        @DisplayName("cuando comprobamos si es el último, es falso")
        void shouldReturnFalseToNodeBeingTheLastNodeOfTheDeque() {
            assertFalse(node.isLastNode());
        }

        @Test
        @DisplayName("cuando comprobamos si no es uno terminal, es verdadero")
        void shouldReturnTrueToNodeNotBeingATerminalNode() {
            assertTrue(node.isNotATerminalNode());
        }
    }
    @Nested
    @DisplayName("cuando se instancia como el último de la Deque")
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
        @DisplayName("cuando pedimos su valor, obtenemos su valor")
        void shouldReturn9AsTheNextNodeItem() {
            int expectedValue = 9;
            int actualValue = nextNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando cambiamos su valor, se actualiza correctamente")
        void shouldSetTheNextNodeItemTo1() {
            nextNode.setItem(1);
            int expectedValue = 1;
            int actualValue = nextNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando pedimos su nodo anterior devuelve dicho nodo")
        void shouldReturnNodeAsThePreviousNode() {
            DequeNode<Integer> expectedValue = node;
            DequeNode<Integer> actualValue = nextNode.getPrevious();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("cuando pedimos su nodo posterior, no obtenemos ningún nodo")
        void shouldReturnNullAsTheNextNode() {
            assertNull(nextNode.getNext());
        }

        @Test
        @DisplayName("cuando comprobamos si es el primero, es falso")
        void shouldReturnFalseToNextNodeBeingTheFirstNodeOfTheDeque() {
            assertFalse(nextNode.isFirstNode());
        }

        @Test
        @DisplayName("cuando comprobamos si es el último, es verdadero")
        void shouldReturnTrueToNextNodeBeingTheLastNodeOfTheDeque() {
            assertTrue(nextNode.isLastNode());
        }

        @Test
        @DisplayName("cuando comprobamos si no es uno terminal, es falso")
        void shouldReturnFalseToNextNodeNotBeingATerminalNode() {
            assertFalse(nextNode.isNotATerminalNode());
        }
    }
}
