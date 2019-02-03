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
    // Returning list's size
    @Override
    public int size() {
        return this.list.size();
    }
    // Returning list's isEmpty function return
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Adds an element to the queue
    // @parameter element to put in the list
    @Override
    public void offer(E element) {
        if(element == null)
            return;
        list.addLast(element);

    }
    // Returns front item in the queue without removing it
    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return list.first();
    }
    // Removes and returns front item in the queue
    @Override
    public E poll() {
        if(isEmpty())
            return null;
        return list.removeFirst();
    }
    // Prints contents of the queue!
    @Override
    public void printQueue() {
        if(isEmpty())
            return;
        list.printList();
    }

     // Transfers the contents of this queue into the provided queue
     // @parameter into The new queue onto which the reversed order of contents from
    @Override
    public void transfer(Queue into) {
        if(into != null || isEmpty())
            return;
        while(this.peek() != null)
            into.offer(this.poll());
    }

    @Override
    public void reverse() {

    }

    @Override
    public void merge(Queue from) {

    }
}
