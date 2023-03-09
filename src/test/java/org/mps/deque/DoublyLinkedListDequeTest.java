package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing DoublyLinkedListDequeTest.java
 *
 * @author Pablo Sánchez González
 */

@DisplayName("Un Deque")
class DoublyLinkedListDequeTest {


    DoubleEndedQueue<Integer> deque;

    @Nested
    @DisplayName("Casos de prueba de la creación de deques")
    class NewDeque{
        @BeforeEach
        void createDeque(){
            deque = new DoublyLinkedListDeque<>();
        }
        @Test
        void newDequeFirstIsNull(){
            assertNull(deque.first());
        }

        @Test
        void newDequeLastIsNull(){
            assertNull(deque.last());
        }

        @Test
        void newDequeSizeIs0(){
            assertEquals(0, deque.size());
        }
    }

    @Nested
    @DisplayName("Casos de prueba de añadir un nodo al principio")
    class PrependingNewNodes{
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
        void prependingANodeInEmptyDequeMakesItHaveSize1(){
            int item = 1;
            deque.prepend(item);
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

        @Test
        void prependingANodeIncreasesSizeBy1(){
            int item1 = 1;
            int item2 = 2;
            deque.prepend(item1);

            int prevSize = deque.size();

            deque.prepend(item2);
            assertEquals(prevSize + 1, deque.size());
        }
    }

    @Nested
    @DisplayName("Casos de prueba de añadir un nodo al final")
    class appendingNewNodes{
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
        void appendingANodeInEmptyDequeMakesItHaveSize1(){
            int item = 1;
            deque.append(item);
            assertEquals(deque.size(), 1);
        }



        @Test
        void appendingNodeInDequeIsLast(){
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);
            deque.append(item2);
            assertEquals(item2, deque.last());
        }



        @Test
        void appendingANodeIncreasesSizeBy1(){
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);

            int prevSize = deque.size();

            deque.append(item2);
            assertEquals(prevSize + 1, deque.size());
        }
    }

    @Nested
    @DisplayName("Casos de prueba de eliminaciones")
    class Deletions{
        @Test
        void deletingFirstNodeFromEmptyDequeThrowsDoubleEndedQueueException(){
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }

        @Test
        void deletingLastNodeFromEmptyDequeThrowsDoubleEndedQueueException(){
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }

        @Test
        void deletingFirstNodeDecreaseSizeBy1(){
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);

            int prevSize = deque.size();

            deque.deleteFirst();
            assertEquals(prevSize - 1, deque.size());
        }

        @Test
        void deletingLastNodeFromDequeDecreaseSizeBy1(){
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);

            int prevSize = deque.size();

            deque.deleteLast();
            assertEquals(prevSize - 1, deque.size());
        }
    }

    @Nested
    @DisplayName("Propiedades")
    class Properties{
        @Test
        void size1DequeFirstEqualsLast(){
            int item = 1;
            deque.prepend(item);
            assertEquals (deque.first(), deque.last());
        }
    }








}