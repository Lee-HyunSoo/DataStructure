package week_4;

public class ArrayStack<T> implements Stack<T> {
    private T[] items;
    private int size = 0;
    private int maxSize = 10;

    public ArrayStack() {
        items = (T[]) new Object[maxSize];
    }
    public ArrayStack(int max) {
        items = (T[]) new Object[max];
        maxSize = max;
    }
    public void clear() {
        size = 0;
        maxSize = 10;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == maxSize;
    }
    public T peek() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return items[size - 1];
    }
    public T pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        T item = items[--size];
        items[size] = null;
        return item;
    }
    public void push(T item) {
        if (isFull())
            resize();
        items[size++] = item;
    }
    public int size() {
        return size;
    }
    public void resize() {
        Object[] newItems = new Object[2 * items.length];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = (T[])newItems;
        maxSize *= 2;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append((items[i]) + " ");
        }
        return sb.toString();
    }
}
