package week_4;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
    static class Node<T> {
        private T item;
        private Node<T> next;

        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        private Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public T peek() {
        return this.top.item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = this.top.item;
        this.top = this.top.next;
        this.size--;
        return item;
    }

    @Override
    public void push(T item) {
        this.top = new Node(item, this.top);
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node temp = this.top;
        while (temp != null) {
            sb.append(temp.item + " ");
            temp = temp.next;
        }
        return sb.toString();
    }
}
