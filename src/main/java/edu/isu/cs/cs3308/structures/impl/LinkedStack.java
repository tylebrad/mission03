/**
 * Author: Bradley Tyler
 * Date: 1/30/2019
 * Class: CS 3308
 * Project: Mission 03
 *
 * Original Code from Mission 02
 *
 * Description - Linked Stack Class
 */
package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

public class LinkedStack<E> implements Stack<E> {

    private int size = 0;
    private Node<E> top = null;  // Top of the stack

    /**
     * Node class nested within DLL
     * @param <E>
     */
    public static class Node<E>{
        private E data;
        private Node<E> next;


        /**
         * Node Constructor
         * @param d Node Data
        */
        public Node(E d){
            this.data = d;
        }

        public E getData(){
            return data;
        }
        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }
    /**
     * @param element Element added to the top of the stack, unless this item is
     * null.
     */
    @Override
    public void push(E element) {
        if (element == null)
            return;
        Node<E> oldTop = top;
        top = new Node<>(element);
        top.next = oldTop;
        size++;
    }

    /**
     * @return The value of the item at the top of the stack, or null if the
     * stack is empty.
     */
    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return top.getData();
    }

    /**
     * @return The value of the top item in the stack, or null if the stack is
     * empty.
     */
    @Override
    public E pop() {
        if(isEmpty())
            return null;
        Node<E> temp = new Node<>(top.getData());
        top = top.next;
        size--;
        return temp.getData();
    }

    /**
     * @return Size of stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return True if this stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Transfers the contents of this stack into the provided stack. The contents
     * of this stack are to found in reverse order at the top of the provided
     * stack. This stack should be empty once the transfer is completed. Note
     * that if the provided stack is null, nothing is to happen.
     *
     * @param to The new stack onto which the reversed order of contents from
     * this stack are to be transferred to the top of, unless the provided stack
     * is null.
     */
    @Override
    public void transfer(Stack<E> to) {
        if (to == null || this.isEmpty())
            return;
        while(this.isEmpty() != true)
            to.push(this.pop());

    }

    /**
     * Reverses the contents of stack.
     */
    @Override
    public void reverse() {
        if (this.isEmpty())
            return;

        LinkedStack<E> tempStack1 = new LinkedStack<>();
        LinkedStack<E> tempStack2 = new LinkedStack<>();


        for(int i = 0; i < size; i++)
        this.push(tempStack1.peek());

    }

    /**
     * Merges the contents of the provided stack onto the bottom of this stack.
     * The order of both stacks must be preserved in the order of this stack
     * after the method call. Furthermore, the provided stack must still contain
     * its original contents in their original order after the method is
     * complete. If the provided stack is null, no changes should occur.
     *
     * @param other Stack whose contents are to be merged onto the bottom of
     * this stack.
     */
    @Override
    public void merge(Stack<E> other) {
        if (other == null || this.isEmpty())
            return;


    }

    /**
     * Prints the contents of the stack starting at top, one item per line. Note
     * this method should not empty the contents of the stack.
     */
    @Override
    public void printStack() {
        if(this.isEmpty())
            return;
        for(int i = 0; i < this.size(); i++){
            System.out.print(this.peek() + System.lineSeparator());
        }

    }
}
