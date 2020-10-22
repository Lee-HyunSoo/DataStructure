package week_7;

public class SortedArrayList<T extends Comparable<T>> implements List<T> {
    private T[] items;
    private int size;
    private int maxSize;
    private int scanPos;

    public SortedArrayList(int max) {
        items = (T[]) new Comparable[max];
        this.size = 0;
        this.maxSize = max;
        this.scanPos = 0;
    }

    public SortedArrayList() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    public boolean isFull() {
        return this.size == this.maxSize;
    }

    @Override
    public void insert(T item) {
        if (isFull())
            resize();
        items[size] = item;
        size++;
        sort();
    }
    public void resize() {
        T[] newItems = (T[]) new Object[maxSize * 2];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
        maxSize *= 2;
    }

    public boolean search(T item) {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        int begin = 0;
        int end = size - 1;
        while(begin <= end) {
            int mid = (begin + end) / 2;

            if(items[mid].compareTo(item) < 0)
                begin = mid + 1;
            else if (items[mid].compareTo(item) > 0)
                end = mid - 1;
            else
                return true;
        }
        return false;
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                items[i] = items[size - 1];
                items[size - 1] = null;
                size--;
                sort();
                return true;
            }
        }
        return false;
    }
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j)
                    continue;
                if (items[i].compareTo(items[j]) > 0) {
                    T item = items[i];
                    items[i] = items[j];
                    items[j] = item;
                }
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void reset() {
        this.scanPos = 0;
    }

    @Override
    public boolean hasNext() {
        return scanPos < size;
    }

    @Override
    public T next() {
        T item = items[scanPos];
        scanPos++;
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(items[i] + " ");
        }
        return sb.toString();
    }
}
