/**
 * Author: Bradley Tyler
 * Date: 1/30/2019
 * Project: Mission 03
 *
 * Original Code from Mission 02
 *
 * Class: CS 3308
 * Professor: Isaac Griffith
 *
 * Description - Doubly Linked List Class
 */
package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

public class DoublyLinkedList<E> implements List<E> {

    /**
     * Node class nested within DLL
     * @param <E>
     */
    public static class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> prev;

        /**
         * Node Constructor
         * @param d Node Data
         * @param n Node's "Next" reference
         * @param p Node's "Previous" reference
         */
        public Node(E d, Node<E> n, Node<E> p){
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

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
    }

    /**
     * Sentinel Nodes and size variable
     */
    private Node<E> head = new Node<>(null, null, null);
    private Node<E> tail = new Node<>(null, null, head);
    private int size = 0;

    /**
     * @return first element in the list or null if the list is empty
     */
    @Override
    public E first() {
        if(isEmpty())
            return null;
        return head.getNext().getData();
    }

    /**
     * @return last element in the list or null if the list is empty.
     */
    @Override
    public E last() {
        if(isEmpty())
            return null;
        return tail.getPrev().getData();
    }

    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     *
     * @param element Element to be added to the end of the list.
     */
    @Override
    public void addLast(E element) {
        if (element == null)
            return;

        Node<E> newNode = new Node<>(element, tail, null);
        //Handling empty list
        if (isEmpty()) {
            head.setNext(newNode);
            tail.setPrev(newNode);
            newNode.setPrev(head);
        }
        tail.prev.setNext(newNode);
        newNode.setPrev(tail.prev);
        tail.prev = newNode;
        size++;
    }

    /**
     * Adds the provided element to the front of the list, only if the element
     * is not null.
     *
     * @param element Element to be added to the front of the list.
     */
    @Override
    public void addFirst(E element) {
        if (element == null)
            return;

        Node<E> newNode = new Node<>(element, null, head);
        //If statement to handle an empty list
        if (isEmpty()) {
            tail.setPrev(newNode);
            head.setNext(newNode);
            newNode.setNext(tail);
        }
        //Normal addFirst logic
        head.getNext().setPrev(newNode);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        size++;

    }

    /**
     * Removes the element at the front of the list.
     *
     * @return Element at the front of the list, or null if the list is empty.
     */
    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;
        Node<E> newTemp = head.getNext();
        head.setNext(newTemp.getNext());
        newTemp.getNext().setPrev(head);
        newTemp.prev = null;
        newTemp.next = null;
        size--;
        return newTemp.getData();
    }

    /**
     * Removes the element at the end of the list.
     *
     * @return Element at the end of the list, or null if the list is empty.
     */
    @Override
    public E removeLast() {
        if(isEmpty())
            return null;
        Node<E> newTemp = tail.getPrev();
        tail.setPrev(newTemp.getPrev());
        newTemp.getPrev().setNext(tail);
        newTemp.next = null;
        newTemp.prev = null;
        size--;
        return newTemp.getData();
    }

    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the element will be added to the end of
     * the list.
     *
     * @param element Element to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     */
    @Override
    public void insert(E element, int index) {
        if(element == null || index < 0)
            return;

        Node<E> newNode = new Node<>(element, null, null);
        Node<E> current = head.getNext();

        if(index >= size()){
            tail.getPrev().setNext(newNode);
            tail.setPrev(newNode);
        }
        else
            for (int i = 0; i < index - 1; i++)
                current = current.getNext();
            Node<E> newTemp = current;
            newNode.setPrev(newTemp);
            newNode.setNext(newTemp.getNext());
            newTemp.getNext().setPrev(newNode);
            newTemp.setNext(newNode);
            size++;

    }

    /**
     * Removes the element at the given index and returns the value.
     *
     * @param index Index of the element to remove
     * @return The value of the element at the given index, or null if the index
     * is greater than or equal to the size of the list or less than 0.
     */
    @Override
    public E remove(int index) {
        if(index < 0 || index >= size)
            return null;

        Node<E> temp = head.getNext();
        for(int i = 0; i < index; i++)
            temp = temp.getNext();
        Node<E> newTemp = temp.getNext();
        newTemp.setPrev(temp.getPrev());
        newTemp.setNext(temp.getNext());
        temp.next = null;
        temp.prev = null;
        size--;
        return temp.getData();
    }

    /**
     * Retrieves the value at the specified index. Will return null if the index
     * provided is less than 0 or greater than or equal to the current size of
     * the list.
     *
     * @param index Index of the value to be retrieved.
     * @return Element at the given index, or null if the index is less than 0
     * or greater than or equal to the list size.
     */
    @Override
    public E get(int index) {
        if(index < 0 || index >= this.size())
            return null;

        Node<E> temp = head.getNext();
        for(int i = 0; i < index; i++)
            temp = temp.getNext();
        return temp.getData();
    }

    /**
     * @return The current size of the list. Note that 0 is returned for an
     * empty list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @return true if there are no items currently stored in the list, false
     * otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the contents of the list each item on its own line
     */
    @Override
    public void printList() {
        if(isEmpty())
            return;
        Node<E> current = this.head.getNext();
        for (int i = 0; i < size(); i++){
            System.out.print(current.data + System.lineSeparator());
            current = current.getNext();
        }
    }
}
