package week_5;

public class ArrayQueue<T> implements Queue<T> {
    private T[] data;
    private int front;
    private int rear;
    private int size;
    private int maxSize;

    public ArrayQueue() {
        this(3);
    }
    public ArrayQueue(int max) {
        maxSize = max;
        data = (T[]) new Object[maxSize];
        front = 0;
        rear = maxSize - 1;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (isFull())
            resize();
        rear = (rear + 1) % maxSize;
        data[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is Empty!");
        }
        else {
            T item = data[front];
            front = (front + 1) % maxSize;
            size--;
            return item;
        }
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("Queue is Empty!");
        return this.data[front];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void clear() {
        maxSize = 3;
        size = 0;
        front = 0;
        rear = maxSize - 1;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int temp = front;
        for (int i = 0; i < size; i++) {
            sb.append(data[temp] + " ");
            temp = (temp + 1) % maxSize;
        }
        return sb.toString();
    }

    public void resize() {
        T[] newData = (T[]) new Object[2 * maxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        data = newData;
        front = 0;
        rear = maxSize - 1;
        maxSize *= 2;
    }
}
