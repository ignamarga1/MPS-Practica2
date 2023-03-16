package org.mps.deque;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing DoublyLinkedListDequeTest.java
 *
 * @author Pablo Sánchez González
 * @author Ignacio Martínez Gallardo
 */

/**
 *
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
 *
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

            int expectedValue = 0;
            int actualValue = deque.size();
            assertEquals(expectedValue, actualValue);
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

                int expectedValue = 1;
                int actualValue = deque.first();

                assertEquals(expectedValue, actualValue);
            }
            @DisplayName("El nodo añadido también es el último")
            @Test
            void prependingNodeInEmptyDequeIsAlsoTheLastNode(){
                int item = 1;
                deque.prepend(item);

                int expectedValue = 1;
                int actualValue = deque.last();

                assertEquals(expectedValue, actualValue);
            }

            @DisplayName("El tamaño es 1 tras la inserción")
            @Test
            void prependingANodeInEmptyDequeMakesItHaveSize1(){
                int item = 1;
                deque.prepend(item);

                int expectedValue = 1;
                int actualValue = deque.size();

                assertEquals(expectedValue, actualValue);
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

                int expectedValue = 2;
                int actualValue = deque.first();

                assertEquals(expectedValue, actualValue);
            }

            @DisplayName("En un deque no vacío, se incrementa el tamaño en 1")
            @Test
            void prependingANodeIncreasesSizeBy1(){
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

                int expectedValue = 1;
                int actualValue = deque.last();

                assertEquals (1, actualValue);
            }

            @DisplayName("El nodo añadido es el primero")
            @Test
            void appendingNodeInEmptyDequeIsAlsoFirstNode(){
                int item = 1;
                deque.append(item);

                int expectedValue = 1;
                int actualValue = deque.first();

                assertEquals (1, actualValue);
            }

            @DisplayName("El tamaño es 1 tras la inserción")
            @Test
            void appendingANodeInEmptyDequeMakesItHaveSize1(){
                int item = 1;
                deque.append(item);

                int expectedValue = 1;
                int actualValue = deque.size();

                assertEquals(expectedValue, actualValue);
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

                int expectedValue = 2;
                int actualValue = deque.last();

                assertEquals(expectedValue, actualValue);
            }

            @DisplayName("Se incrementa el tamaño en 1")
            @Test
            void appendingANodeIncreasesSizeBy1(){
                int item1 = 1;
                int item2 = 2;
                deque.append(item1);

                int prevSize = deque.size();

                deque.append(item2);

                int expectedValue = prevSize + 1;
                int actualValue = deque.size();

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

            int expectedValue = prevSize - 1;
            int actualValue = deque.size();

            assertEquals(expectedValue, actualValue);
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

            int expectedValue = prevSize - 1;
            int actualValue = deque.size();

            assertEquals(expectedValue, actualValue);
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


    @Nested
    @DisplayName("Obtener un nodo a partir de su índice")
    class Get {
        @BeforeEach
        void setUp() {
            deque = new DoublyLinkedListDeque<>();
            for(int i = 0; i < 5; i++) {
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
        @DisplayName("cuando la DoublyLinkedListDeque está vacía")
        void shouldThrowAnExceptionToGettingTheNodeForAnEmptyDeque() {
            for(int i = 0; i < deque.size(); i++) {
                deque.remove(i);
            }

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
            for(int i = 0; i < 5; i++) {
                deque.prepend(i);
            }
        }

        @AfterEach
        void shutdown() {
            deque = null;
        }

        /*
        @Test
        @DisplayName("cuando la deque está vacía")
        void shouldThrowAnExceptionWhenTryingToRemoveANodeFromAnEmptyDeque() {
            for(int i = 0; i < deque.size(); i++) {
                deque.remove(i);
            }

            assertThrows(DoubleEndedQueueException.class, () -> deque.remove(7));
        }
        */
    }

    @Nested
    @DisplayName("Ordenar un deque")
    class Sort{

        int[] sortedDequeValues;
        Comparator<Integer> comparator;


        @BeforeEach
        void createValues(){

            deque = new DoublyLinkedListDeque<>();

            sortedDequeValues = new int[8];
            for(int i = 0; i < 8; i++){
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
        void noChangesToAnAlreadySortedDeque(){

            for(int i = 0; i < 8; i++){
                deque.append(sortedDequeValues[i]);
            }

            deque.sort(comparator);

            int[] obtainedValues = new int[deque.size()];

            for(int i = 0; i < deque.size(); i++){
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);

        }

        @Test
        void sortingTestOfSwappedValuesDeque(){

            for(int i = 0; i < 8; i++){
                if(i % 2 == 0){
                    deque.append(i+1);
                } else {
                    deque.append(i-1);
                }
            }

            deque.sort(comparator);
            int[] obtainedValues = new int[deque.size()];

            for(int i = 0; i < deque.size(); i++){
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);

        }

        @Test
        void sortingTestOfMoreSwappedValuesDeque(){

            for(int i = 0; i < 8; i++){
                deque.append((i+4) % 8);
            }

            deque.sort(comparator);
            int[] obtainedValues = new int[deque.size()];

            for(int i = 0; i < deque.size(); i++){
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);

        }

        @Test
        void sortingTestOfWorstCaseDeque(){

            for(int i = 0; i < 8; i++){
                deque.append(7-i);
            }

            deque.sort(comparator);
            int[] obtainedValues = new int[deque.size()];

            for(int i = 0; i < deque.size(); i++){
                obtainedValues[i] = deque.get(i);
            }

            assertArrayEquals(sortedDequeValues, obtainedValues);

        }

    }

    @Nested
    @DisplayName("Al comprobar si un elemento se encuentra en la cola")
    class contains{

        @BeforeEach
        void createDeque(){
            deque = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("Devuelve FALSE si la cola está vacía")
        void anEmptyDequeReturnsFalse(){
            assertFalse(deque.contains(1));
        }

        @Test
        @DisplayName("Devuelve TRUE si el elemento se encuentra en la cola")
        void contains1AfterAppending1(){
            deque.append(1);
            assertTrue(deque.contains(1));
        }

        @Test
        @DisplayName("Devuelve FALSE si el elemento NO se encuentra en la cola")
        void doesntContain2AfterAppending1(){
            deque.append(1);
            assertFalse(deque.contains(2));
        }

    }

}