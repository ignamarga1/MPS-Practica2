package org.mps.deque;

import java.util.Deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        if(size == 0){
            this.first = new DequeNode<>(value, null, null);
            this.last = this.first;
        } else if (size == 1){
            this.first = new DequeNode<>(value, null, this.last);
            this.last.setPrevious(this.first);
        } else {
            DequeNode<T> newNode = new DequeNode<>(value, null, this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }

        size++;
    }

    @Override
    public void append(T value) {
        if(size == 0){
            this.first = new DequeNode<>(value, null, null);
            this.last = this.first;
        } else if (size == 1){
            this.first = new DequeNode<>(value, this.first, null);
            this.last.setPrevious(this.first);
        } else {
            DequeNode<T> newNode = new DequeNode<>(value, this.last, null);
            this.last.setNext(newNode);
            this.last = newNode;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if(size == 0){
            throw new DoubleEndedQueueException("La cola está vacía");
        } else if (size == 1){
            this.first = null;
            this.last = null;
            size--;
        } else {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if(size == 0){
            throw new DoubleEndedQueueException("La cola está vacía");
        } else if (size == 1){
            this.first = null;
            this.last = null;
            size--;
        } else {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
            size--;
        }
    }

    @Override
    public T first() {
        return this.first.getItem();
    }

    @Override
    public T last() {
        return this.last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
