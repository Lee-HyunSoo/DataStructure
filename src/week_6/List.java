package week_6;

public interface List<T> {
    public boolean isEmpty();
    public void insert(T item);
    public boolean remove(T item);
    public boolean search(T item);
    public int size();
    public String toString();

    public void reset();
    public boolean hasNext();
    public T next();

    public void insert(int num, T item);
    public void delete(int num);
    public void append(T item);
    public T retrieve(int num);
}
