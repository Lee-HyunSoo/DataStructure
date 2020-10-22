package week_6;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> scanPos;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;

        private Node() {

        }
        private Node(T item) {
            this.item = item;
            this.next = null;
        }
        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(T item) {
        Node<T> newNode = new Node<T>(item, head);
        head = newNode;
        size++;
    }

    @Override
    public boolean remove(T item) {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("search() : list empty");
        }
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            if (curr.item.equals(item))
                break;
            prev = curr;
            curr = curr.next;
        }

        if (curr == null)
            return false;
        else if (prev == null)
            head = head.next;
        else
            prev.next = curr.next;
        size--;
        return true;
    }

    @Override
    public boolean search(T item) {
        if(isEmpty()) {
            throw new java.util.NoSuchElementException("search() : list empty");
        }
        Node<T> temp = head;
        while(temp != null) {
            if (temp.item.equals(item))
                return true;
            else
                temp = temp.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void reset() {
        scanPos = head;
    }

    @Override
    public boolean hasNext() {
        return scanPos != null;
    }

    @Override
    public T next() {
        T item = scanPos.item;
        scanPos = scanPos.next;
        return item;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> scan = head;
        while(scan != null) {
            sb.append(scan.item + " ");
            scan = scan.next;
        }
        return sb.toString();
    }

    @Override
    public void insert(int pos, T item) {
        Node<T> newNode = new Node<T>(item, null);
        Node<T> temp = head;
        int cnt = 1;

        if (head == null)
            head = newNode;
        else {
            while (cnt != pos - 1) {
                temp = temp.next;
                cnt++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    @Override
    public void delete(int pos) {
        Node<T> temp = head;
        int cnt = 1;
        if (head == null) return;
        else {
            while (cnt != pos - 1) {
                temp = temp.next;
                cnt++;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    @Override
    public void append(T item) {
        Node<T> newNode = new Node<T>(item);
        Node<T> temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        size++;
    }

    @Override
    public T retrieve(int pos) {
        Node<T> temp = head;
        int cnt = 1;
        while (cnt != pos) {
            temp = temp.next;
            cnt++;
        }

        return temp.item;
    }
}
