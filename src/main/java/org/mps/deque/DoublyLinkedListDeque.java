package org.mps.deque;

import java.util.Comparator;
import java.util.Deque;

/**
 * Class for testing DoublyLinkedListDequeTest.java
 *
 * @author Pablo Sánchez González
 */
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
        if(this.first == null){
            return null;
        } else
        return this.first.getItem();
    }

    @Override
    public T last() {

        if(this.last == null){
            return null;
        } else
        return this.last.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    private DequeNode<T> getNodeByValue(T value){
        boolean found = false;
        DequeNode<T> node = this.first;

        while(!found && node != null){

            if(node.getItem().equals(value)){
                found = true;
            } else {
                node = node.getNext();
            }

        }

        return node;
    }

    @Override
    public T get(int index) {
        DequeNode<T> node = this.first;

        for(int i = 0; i < index; i++){
            node = node.getNext();
        }
        return node.getItem();
    }

    @Override
    public boolean contains(T value) {
        return getNodeByValue(value) != null;
    }

    @Override
    public void remove(T value) {

    }

    @Override
    public void sort(Comparator<? super T> comparator) {



    }
}
