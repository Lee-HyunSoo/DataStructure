package week_5;

public class LinkedQueue<T> implements Queue<T> {

    static class Node<T> {
        private T data;
        private Node<T> link;

        private Node (T data, Node<T> link) {
            this.data = data;
            this.link = link;
        }
        private Node (T data) {
            this.data = data;
            this.link = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedQueue () {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<T> (item);
        if (front == null) {
            front = newNode;
            rear = newNode;
            size++;
        }
        else {
            rear.link = newNode;
            rear = newNode;
            size++;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is Empty!");
        }
        else {
            T data = front.data;
            front = front.link;
            if (front == null) rear = null;
            size--;
            return data;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is Empty!");
        }
        else {
            return this.front.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = front;
        while (temp != null) {
            sb.append(temp.data + " ");
            temp = temp.link;
        }
        return sb.toString();
    }
}
