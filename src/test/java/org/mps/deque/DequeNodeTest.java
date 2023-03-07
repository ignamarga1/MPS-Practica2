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
    DequeNode<Integer> node;

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
    void theComputedMethodShouldReturnTheSetItem() {

    }
}