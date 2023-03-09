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

    private boolean isEmpty(DoubleEndedQueue d){
        return d.first() == null && d.last() == null;
    }

    @Nested
    @DisplayName("Casos de prueba de un deque recién creado")
    class NewDeque{
        @BeforeEach
        void createDeque(){
            deque = new DoublyLinkedListDeque<>();
        }

        @DisplayName("El primer nodo es nulo")
        @Test
        void newDequeFirstIsNull(){
            assertNull(deque.first());
        }

        @DisplayName("El último nodo es nulo")
        @Test
        void newDequeLastIsNull(){
            assertNull(deque.last());
        }

        @DisplayName("El tamaño es 0")
        @Test
        void newDequeSizeIs0(){
            assertEquals(0, deque.size());
        }
    }

    @Nested
    @DisplayName("Casos de prueba de añadir un nodo al principio")
    class PrependingNewNodes{

        @Nested
        @DisplayName("En un deque vacío")
        class EmptyDeque{

            @BeforeEach
            void createDeque(){
                deque = new DoublyLinkedListDeque<>();
            }
            @Test
            @DisplayName("El nodo añadido es el primero")
            void prependingNodeInEmptyDequeIsTheFirstNode(){
                int item = 1;
                deque.prepend(item);
                assertEquals(item, deque.first());
            }
            @DisplayName("El nodo añadido también es el último")
            @Test
            void prependingNodeInEmptyDequeIsAlsoTheLastNode(){
                int item = 1;
                deque.prepend(item);
                assertEquals(item, deque.last());
            }

            @DisplayName("El tamaño es 1 tras la inserción")
            @Test
            void prependingANodeInEmptyDequeMakesItHaveSize1(){
                int item = 1;
                deque.prepend(item);
                assertEquals(deque.size(), 1);
            }


        }

        @Nested
        @DisplayName("En un deque no vacío")
        class NonEmptyDeques{
            @BeforeEach
            void createDeque(){
                deque = new DoublyLinkedListDeque<>();
            }

            @DisplayName("En un deque no vacío, el nodo añadido es el primero")
            @Test
            void prependingNodeInDequeIsFirst() {
                int item1 = 1;
                int item2 = 2;
                deque.prepend(item1);
                deque.prepend(item2);
                assertEquals(item2, deque.first());
            }

            @DisplayName("En un deque no vacío, se incrementa el tamaño en 1")
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

    }

    @Nested
    @DisplayName("Casos de prueba de añadir un nodo al final")
    class appendingNewNodes{

        @Nested
        @DisplayName("En un deque vacío")
        class EmptyDeque{
            @BeforeEach
            void createDeque(){
                deque = new DoublyLinkedListDeque<>();
            }
            @DisplayName("El nodo añadido es el último")
            @Test
            void appendingNodeInEmptyDequeIsLastNode(){
                int item = 1;
                deque.append(1);
                assertEquals (item, deque.last());
            }

            @DisplayName("El nodo añadido es el primero")
            @Test
            void appendingNodeInEmptyDequeIsAlsoFirstNode(){
                int item = 1;
                deque.append(item);
                assertEquals (item, deque.first());
            }

            @DisplayName("El tamaño es 1 tras la inserción")
            @Test
            void appendingANodeInEmptyDequeMakesItHaveSize1(){
                int item = 1;
                deque.append(item);
                assertEquals(deque.size(), 1);
            }


        }

        @Nested
        @DisplayName("En un deque no vacío")
        class NonEmptyDeque{

            @BeforeEach
            void createDeque(){
                deque = new DoublyLinkedListDeque<>();
            }

            @DisplayName("El nodo añadido es el último")
            @Test
            void appendingNodeInDequeIsLast(){
                int item1 = 1;
                int item2 = 2;
                deque.append(item1);
                deque.append(item2);
                assertEquals(item2, deque.last());
            }

            @DisplayName("Se incrementa el tamaño en 1")
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
    }

    @Nested
    @DisplayName("Casos de prueba de eliminar el primer nodo")
    class DeleteFirst{

        @BeforeEach
        void createDeque(){
            deque = new DoublyLinkedListDeque<>();
        }

        @DisplayName("En un deque vacío, salta una DoubleEndedQueueException")
        @Test
        void deletingFirstNodeFromEmptyDequeThrowsDoubleEndedQueueException(){
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }

        @DisplayName("En un deque de tamaño 1, el deque resultante es un deque vacío")
        @Test
        void deletingFirstNodeFromSize1DequeResultsInEmptyDeque(){
            int item = 1;
            deque.append(1);

            deque.deleteFirst();
            assertTrue(isEmpty(deque));
        }

        @DisplayName("En un deque no vacío, se decrementa el tamaño en 1")
        @Test
        void deletingFirstNodeDecreaseSizeBy1(){
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);
            deque.append(item2);

            int prevSize = deque.size();

            deque.deleteFirst();
            assertEquals(prevSize - 1, deque.size());
        }


    }

    @Nested
    @DisplayName("Casos de prueba de eliminar el último nodo")
    class DeleteLast{

        @BeforeEach
        void createDeque(){
            deque = new DoublyLinkedListDeque<>();
        }

        @DisplayName("En un deque vacío, salta una DoubleEndedQueueException")
        @Test
        void deletingLastNodeFromEmptyDequeThrowsDoubleEndedQueueException(){
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }

        @DisplayName("En un deque de tamaño 1, el deque resultante es un deque vacío")
        @Test
        void deletingLastNodeFromSize1DequeResultsInEmptyDeque(){
            int item = 1;
            deque.append(1);

            deque.deleteLast();
            assertTrue(isEmpty(deque));
        }

        @DisplayName("En un deque no vacío, se decrementa el tamaño en 1")
        @Test
        void deletingLastNodeFromDequeDecreaseSizeBy1(){
            int item1 = 1;
            int item2 = 2;
            deque.append(item1);
            deque.append(item2);

            int prevSize = deque.size();

            deque.deleteLast();
            assertEquals(prevSize - 1, deque.size());
        }
    }

    @Nested
    @DisplayName("Propiedades")
    class Properties{

        @BeforeEach
        void createDeque(){
            deque = new DoublyLinkedListDeque<>();
        }

        @DisplayName("En un deque de tamaño 1, el primer y último nodo es el mismo")
        @Test
        void size1DequeFirstEqualsLast(){
            int item = 1;
            deque.prepend(item);
            assertEquals (deque.first(), deque.last());
        }
    }

}