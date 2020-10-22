package week_7;

public class SortedLinkedList<T extends Comparable<T>> implements List<T> {
    static class Node<T> {
        private T item;
        private Node<T> next;

        public Node (T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
        public Node(T item) {
            this(item, null);
        }
    }

    private Node<T> head;
    private int size;
    private Node<T> scanPos;

    public SortedLinkedList() {
        this.head = null;
        this.scanPos = null;
        this.size = 0;
    }


    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void insert(T item) {
        if(isEmpty())
            this.head = new Node(item);
        else {
            Node<T> prev = null;
            Node<T> curr = head;

            while (curr != null) {
                if (curr.item.compareTo(item) <= 0)
                    break;
                prev = curr;
                curr = curr.next;
            }
            if (prev == null) {
                this.head = new Node<T>(item, head);
            }
            else {
                prev.next = new Node<T> (item, curr);
            }
        }
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void reset() {
        this.scanPos = this.head;
    }

    @Override
    public boolean hasNext() {
        return this.scanPos != null;
    }

    @Override
    public T next() {
        T item = this.scanPos.item;
        this.scanPos = this.scanPos.next;
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = this.head;
        while(temp != null) {
            sb.append(temp.item);
            temp = temp.next;
        }
        return sb.toString();
    }
}
