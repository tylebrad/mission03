/**
 * Bradley Tyler
 * CS 3308
 * Mission 03
 *
 * LinkedQueue class, implementing Queue
 */
package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.impl.SinglyLinkedList;

public class LinkedQueue<E> implements Queue {
    private  int size = 0;
    private Node<E> front = null;
    private Node<E> back = null;

    /**
     * Node class nested within DLL
     * @param <E>
     */
    public static class Node<E>{
        private E data;
        private DoublyLinkedList.Node<E> next;
        private DoublyLinkedList.Node<E> prev;

        /**
         * Node Constructor
         * @param d Node Data
         * @param n Node's "Next" reference
         * @param p Node's "Previous" reference
         */
        public Node(E d, DoublyLinkedList.Node<E> n, DoublyLinkedList.Node<E> p){
            this.data = d;
            this.next = n;
            this.prev = p;
        }

        public E getData(){
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public DoublyLinkedList.Node<E> getNext(){
            return next;
        }

        public void setNext(DoublyLinkedList.Node<E> next) {
            this.next = next;
        }

        public DoublyLinkedList.Node<E> getPrev(){
            return prev;
        }

        public void setPrev(DoublyLinkedList.Node<E> prev){
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (front == null)
            return true;
        else
            return false;
    }

    /**
     * Adds element to the back of the queue
     * @param element Element to be inserted.
     */
    @Override
    public void offer(Object element) {
        if(element == null)
            return;

        if(size() == 0)
            front.insert(element);

    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Object poll() {
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
