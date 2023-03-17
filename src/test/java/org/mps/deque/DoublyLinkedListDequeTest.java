package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing DoublyLinkedListDequeTest.java
 *
 * @author Pablo Sánchez González
 * @author Ignacio Martínez Gallardo
 */

/**
 * 1. Comprueba que, al crear un nuevo deque, su primer elemento es nulo
 * 2. Comprueba que, al crear un nuevo deque, su último elemento es nulo
 * 3. Comprueba que, al crear un nuevo deque, su tamaño es 0
 * 4. Comprueba que, al insertar un nodo al principio de un deque vacío, el nuevo nodo es el primero
 * 5. Comprueba que, al insertar un nodo al principio de un deque vacío, el nuevo nodo es también el último
 * 6. Comprueba que, al insertar un nodo al principio de un deque vacío, el tamaño del deque es 1
 * 7. Comprueba que, al insertar un nodo al principio de un deque no vacío, el nuevo nodo es el primero
 * 8. Comprueba que, al insertar un nodo al principio de un deque no vacío, el tamaño del deque se incrementa en 1
 * 9. Comprueba que, al insertar un nodo al final de un deque vacío, el nuevo nodo es el último
 * 10. Comprueba que, al insertar un nodo al final de un deque vacío, el nuevo nodo es también el primero
 * 11. Comprueba que, al insertar un nodo al final de un deque vacío, el tamaño del deque es 1
 * 12. Comprueba que, al insertar un nodo al final de un deque no vacío, el nodo añadido es el último
 * 13. Comprueba que, al insertar un nodo al final de un deque no vacío, el tamaño del deque se incrementa en 1
 * 14. Comprueba que, al intentar borrar el primer elemento de un deque vacío, se lanza una excepción de tipo DoubleEndedQUeueException
 * 15. Comprueba que, al borrar el primer elemento de un deque de tamaño 1, el deque queda vacío
 * 16. Comprueba que, al borrar el primer elemento de un deque de tamaño superior a 1, el deque decrementa su tamaño en 1
 * 17. Comprueba que, al intentar borrar el último elemento de un deque vacío, se lanza una excepción de tipo DoubleEndedQUeueException
 * 18. Comprueba que, al borrar el último elemento de un deque de tamaño 1, el deque queda vacío
 * 19. Comprueba que, al borrar el último elemento de un deque de tamaño superior a 1, el deque decrementa su tamaño en 1
 * 20. Comprueba que, si un deque tiene tamaño 1, su primer y último elemento son iguales
 */

@DisplayName("Un Deque")
class DoublyLinkedListDequeTest {

    DoubleEndedQueue<Integer> deque;

    private boolean isEmpty(DoubleEndedQueue d) {
        return d.first() == null && d.last() == null;
    }

    @Nested
    @DisplayName("es creado")
    class NewDeque {
        @BeforeEach
        void createDeque() {
            deque = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("cuando pedimos el primer elemento devuelve null")
        void shouldReturnNullToNewDequeFirst() {
            assertNull(deque.first());
        }

        @Test
        @DisplayName("cuando pedimos el último elemento devuelve null")
        void shouldReturnNullToNewDequeLast() {
            assertNull(deque.last());
        }

        @Test
        @DisplayName("su tamaño es 0")
        void newDequeSizeIs0() {
            int expectedValue = 0;
            int actualValue = deque.size();
            assertEquals(expectedValue, actualValue);
        }
    }

    @Nested
    @DisplayName("al añadir un nodo al principio usando prepend")
    class PrependingNewNodes {
        @Nested
        @DisplayName("cuando el deque vacío")
        class EmptyDeque {
            @BeforeEach
            void createDeque() {
                deque = new DoublyLinkedListDeque<>();
            }

            @Test
            @DisplayName("el nodo añadido es el primero")
            void prependingANodeInEmptyDequeMakesItTheFirstNode() {
                int item = 1;
                deque.prepend(item);

                int expectedValue = 1;
                int actualValue = deque.first();

                assertEquals(expectedValue, actualValue);
            }

            @Test
            @DisplayName("el nodo añadido también es el último")
            void prependingANodeInEmptyDequeIsAlsoMakesItTheLastNode() {
                int item = 1;
                deque.prepend(item);

                int expectedValue = 1;
                int actualValue = deque.last();

                assertEquals(expectedValue, actualValue);
            }

            @Test
            @DisplayName("el tamaño pasa a ser 1")
            void prependingANodeInEmptyDequeMakesItHaveSize1() {
                int item = 1;
                deque.prepend(item);

                int expectedValue = 1;
                int actualValue = deque.size();

                assertEquals(expectedValue, actualValue);
            }
        }

        @Nested
        @DisplayName("cuando el deque no está vacío")
        class NonEmptyDeques {
            @BeforeEach
            void createDeque() {
                deque = new DoublyLinkedListDeque<>();
            }

            @Test
            @DisplayName("el nodo añadido es el primero")
            void prependingNodeInDequeIsFirst() {
                int item1 = 1;
                int item2 = 2;
                deque.prepend(item1);
                deque.prepend(item2);

                int expectedValue = 2;
                int actualValue = deque.first();

                assertEquals(expectedValue, actualValue);
            }

            @Test
            @DisplayName("se incrementa el tamaño en 1")
            void prependingANodeIncreasesSizeBy1() {
                int item1 = 1;
                int item2 = 2;
                deque.prepend(item1);

                int prevSize = deque.size();

                deque.prepend(item2);

                int expectedValue = prevSize + 1;
                int actualValue = deque.size();

                assertEquals(expectedValue, actualValue);
            }
        }
    }

    @Nested
    @DisplayName("al añadir un nodo al final usando append")
    class appendingNewNodes {

        @Nested
        @DisplayName("cuando el deque está vacío")
        class EmptyDeque {
            @BeforeEach
            void createDeque() {
                deque = new DoublyLinkedListDeque<>();
            }

            @Test
            @DisplayName("el nodo añadido es el último")
            void appendingNodeInEmptyDequeIsLastNode() {
                int item = 1;
                deque.append(1);

                int expectedValue = 1;
                int actualValue = deque.last();

                assertEquals(1, actualValue);
            }

            @Test
            @DisplayName("el nodo añadido también es el último")
            void appendingNodeInEmptyDequeIsAlsoFirstNode() {
                int item = 1;
                deque.append(item);

                int expectedValue = 1;
                int actualValue = deque.first();

                assertEquals(1, actualValue);
            }

            @Test
            @DisplayName("se incrementa el tamaño en 1")
            void appendingANodeInEmptyDequeMakesItHaveSize1() {
                int item = 1;
                deque.append(item);

                int expectedValue = 1;
                int actualValue = deque.size();

                assertEquals(expectedValue, actualValue);
            }
        }

        @Nested
        @DisplayName("cuando el deque no está vacío")
        class NonEmptyDeque {
            @BeforeEach
            void createDeque() {
                deque = new DoublyLinkedListDeque<>();
            }

            @Test
            @DisplayName("el nodo añadido es el último")
            void appendingNodeInDequeIsLast() {
                int item1 = 1;
                int item2 = 2;
                deque.append(item1);
                deque.append(item2);

                int expectedValue = 2;
                int actualValue = deque.last();

                assertEquals(expectedValue, actualValue);
            }

            @Test
            @DisplayName("se incrementa el tamaño en 1")
            void appendingANodeIncreasesSizeBy1() {
                int item1 = 1;
                int item2 = 2;
                deque.append(item1);

                int prevSize = deque.size();

                deque.append(item2);

                int expectedValue = prevSize + 1;
                int actualValue = deque.size();

                assertEquals(expectedValue, actualValue);
            }
        }
    }

    @Nested
    @DisplayName("al eliminar el primer nodo con deleteFirst")
    class DeleteFirst {
        @BeforeEach
        void createDeque() {
            deque = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("cuando el deque está vacío, se lanza una DoubleEndedQueueException")
        void deletingFirstNodeFromEmptyDequeThrowsDoubleEndedQueueException() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }

        @Test
        @DisplayName("cuando el deque tiene tamaño 1, el deque resultante está vacío")
        void deletingFirstNodeFromSize1DequeResultsInEmptyDeque() {
            int item = 1;
            deque.append(1);

            deque.deleteFirst();
            assertTrue(isEmpty(deque));
        }

        @Test
        @DisplayName("cuando el deque no está vacío, se decrementa el tamaño en 1")
        void deletingFirstNodeDecreaseSizeBy1() {
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);
            deque.append(item2);

            int prevSize = deque.size();

            deque.deleteFirst();

            int expectedValue = prevSize - 1;
            int actualValue = deque.size();

            assertEquals(expectedValue, actualValue);
        }
    }

    @Nested
    @DisplayName("al eliminar el último nodo con deleteLast")
    class DeleteLast {
        @BeforeEach
        void createDeque() {
            deque = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("cuando el deque está vacío, se lanza una DoubleEndedQueueException")
        void deletingLastNodeFromEmptyDequeThrowsDoubleEndedQueueException() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }

        @Test
        @DisplayName("cuando el deque tiene tamaño 1, el deque resultante está vacío")
        void deletingLastNodeFromSize1DequeResultsInEmptyDeque() {
            int item = 1;
            deque.append(1);

            deque.deleteLast();
            assertTrue(isEmpty(deque));
        }

        @Test
        @DisplayName("cuando el deque no está vacío, se decrementa el tamaño en 1")
        void deletingLastNodeFromDequeDecreaseSizeBy1() {
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);
            deque.append(item2);

            int prevSize = deque.size();

            deque.deleteLast();

            int expectedValue = prevSize - 1;
            int actualValue = deque.size();

            assertEquals(expectedValue, actualValue);
        }
    }

    @Nested
    @DisplayName("Propiedades:")
    class Properties {
        @BeforeEach
        void createDeque() {
            deque = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("dado un deque de tamaño 1, el primer y último nodo es el mismo")
        void size1DequeFirstEqualsLast() {
            int item = 1;
            deque.prepend(item);

            assertEquals(deque.first(), deque.last());
        }
    }

    @Nested
    @DisplayName("Obtener el valor de un nodo a partir de su índice")
    class Get {
        @BeforeEach
        void setUp() {
            deque = new DoublyLinkedListDeque<>();
            for (int i = 0; i < 5; i++) {
                deque.prepend(i);
            }
        }

        @AfterEach
        void shutdown() {
            deque = null;
        }

        @Test
        @DisplayName("cuando dicho índice sea negativo")
        void shouldThrowAnExceptionToGettingTheNodeForANegativeIndexValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.get(-1));
        }

        @Test
        @DisplayName("cuando dicho índice sea mayor que el número de nodos que hay en la deque")
        void shouldThrowAnExceptionToGettingTheNodeForAnOutOfBoundsIndexValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.get(8));
        }

        @Test
        @DisplayName("cuando la deque está vacía")
        void shouldThrowAnExceptionToGettingTheNodeForAnEmptyDeque() {

            deque = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> deque.get(2));
        }

        @Test
        @DisplayName("cuando dicho índice es correcto")
        void shouldReturn3AsTheNodeValueWhenTheIndexIs1() {
            int expectedValue = 3;
            int actualValue = deque.get(1);

            assertEquals(expectedValue, actualValue);
        }
    }

    @Nested
    @DisplayName("Quitar un nodo de la deque")
    class Remove {
        @BeforeEach
        void setUp() {
            deque = new DoublyLinkedListDeque<>();
            for (int i = 0; i < 5; i++) {
                deque.prepend(i);
            }
        }

        @AfterEach
        void shutdown() {
            deque = null;
        }


        @Test
        @DisplayName("cuando la deque está vacía")
        void shouldThrowAnExceptionWhenTryingToRemoveANodeFromAnEmptyDeque() {

            int size = deque.size();

            for (int i = 0; i < size; i++) {
                deque.remove(i);
            }

            assertThrows(DoubleEndedQueueException.class, () -> deque.remove(7));
        }

        @Test
        @DisplayName("cuando solo queda un elemento")
        void removingAllElementsExceptOneResultsInSize1Deque() {

            int size = deque.size();

            for (int i = 0; i < size - 1; i++) {
                deque.remove(i + 1);
            }

            int expectedValue = 1;
            int actualValue = deque.size();

            assertEquals(expectedValue, actualValue);
        }
    }

    @Nested
    @DisplayName("Ordenar un deque")
    class Sort {

        int[] sortedDequeValues;
        Comparator<Integer> comparator;

        @BeforeEach
        void createValues() {

            deque = new DoublyLinkedListDeque<>();

            sortedDequeValues = new int[8];
            for (int i = 0; i < 8; i++) {
                sortedDequeValues[i] = i;
            }

            comparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            };
        }

        @Test
        @DisplayName("cuando sus valores ya están ordenados")
        void noChangesToAnAlreadySortedDeque() {

            for (int i = 0; i < 8; i++) {
                deque.append(sortedDequeValues[i]);
            }

            deque.sort(comparator);

            int[] obtainedValues = new int[deque.size()];

            for (int i = 0; i < deque.size(); i++) {
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);
        }

        @Test
        @DisplayName("cuando algunos valores están desordenados")
        void sortingTestOfSwappedValuesDeque() {

            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    deque.append(i + 1);
                } else {
                    deque.append(i - 1);
                }
            }

            deque.sort(comparator);
            int[] obtainedValues = new int[deque.size()];

            for (int i = 0; i < deque.size(); i++) {
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);
        }

        @Test
        @DisplayName("cuando muchos valores están desordenados")
        void sortingTestOfMoreSwappedValuesDeque() {

            for (int i = 0; i < 8; i++) {
                deque.append((i + 4) % 8);
            }

            deque.sort(comparator);
            int[] obtainedValues = new int[deque.size()];

            for (int i = 0; i < deque.size(); i++) {
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);
        }

        @Test
        @DisplayName("cuando sus valores están ordenados de mayor a menor")
        void sortingTestOfWorstCaseDeque() {

            for (int i = 0; i < 8; i++) {
                deque.append(7 - i);
            }

            deque.sort(comparator);
            int[] obtainedValues = new int[deque.size()];

            for (int i = 0; i < deque.size(); i++) {
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);
        }
    }

    @Nested
    @DisplayName("Comprobar si un elemento se encuentra en la deque")
    class contains {

        @BeforeEach
        void createDeque() {
            deque = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("cuando está vacía devuelve FALSE")
        void anEmptyDequeReturnsFalse() {
            assertFalse(deque.contains(1));
        }

        @Test
        @DisplayName("cuando el elemento SI está contenido devuelve TRUE")
        void contains1AfterAppending1() {
            deque.append(1);
            assertTrue(deque.contains(1));
        }

        @Test
        @DisplayName("cuando el elemento NO está contenido devuelve FALSE")
        void doesntContain2AfterAppending1() {
            deque.append(1);
            assertFalse(deque.contains(2));
        }
    }
}