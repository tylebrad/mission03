/**
 * Bradley Tyler
 * CS 3308
 * Mission 03
 *
 * LinkedQueue class, implementing Queue interface
 */
package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;

public class LinkedQueue<E> implements Queue<E> {
    // Creation of SLL 'list' to build a Queue upon
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    // New Queue
    public LinkedQueue(){}
    // declaring he Queue's size, front, and ack
    private int size = 0;
    private Node<E> front = null;
    private Node<E> back = null;

    // Next Node Class
    private class Node<E>{
        private E data;
        private Node<E> next;
        // gets data from node
        private E getData(){
            return data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds element to the back of the queue
     * @param element Element to be inserted.
     */
    @Override
    public void offer(E element) {
        if(element == null)
            return;
        list.addLast(element);
        size++;

    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return front.getData();
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;
        return null;
    }

    @Override
    public void printQueue() {

    }

    @Override
    public void transfer(Queue into) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void merge(Queue from) {

    }
}
