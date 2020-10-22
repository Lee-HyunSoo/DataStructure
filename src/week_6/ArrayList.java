package week_6;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int maxSize;
    private int scanPos;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int max) {
        items = (T[]) new Object[max];
        maxSize = max;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void insert(T item) {
        if (isFull()) {
            resize();
        }
        items[size++] = item;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                items[i] = items[--size];
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean search(T item) {
        if (isEmpty())
            throw new java.util.NoSuchElementException("search : list empty");
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public void resize() {
        T[] newItems = (T[]) new Object[2 * items.length];

        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
        maxSize *= 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(items[i] + " ");
        }
        return sb.toString();
    }

    @Override
    // 탐색하는 인덱스 -> 인덱스를 처음으로 되돌림
    public void reset() {
        scanPos = 0;
    }

    @Override
    // 스캔포지션이 배열안에있느냐를 확인하기위해
    public boolean hasNext() {
        return scanPos < size;
    }

    @Override
    public T next() {
        return items[scanPos++];
    }

    @Override
    public void insert(int num, T item) {

    }

    @Override
    public void delete(int num) {

    }

    @Override
    public void append(T item) {

    }

    @Override
    public T retrieve(int num) {
        return null;
    }
}
