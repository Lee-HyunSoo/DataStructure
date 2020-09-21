package week_3;

public class Date {
    private int year, month, day;
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int compareTo(Date d) {
        if (year < d.year)
            return -1;
        else if (year > d.year)
            return 1;
        else if (month < d.month)
            return -1;
        else if (month > d.month)
            return 1;
        else if (day < d.day)
            return -1;
        else if (day > d.day)
            return 1;
        else
            return 0;
    }

    public String toString() {
        return year + "/" + month + "/" + day;
    }
}

class Node {
    public Date item;
    public Node next;
    public Node (Date item, Node next) {
        this.item = item;
        this.next = next;
    }
    public Node(Date item) {
        this(item, null);
    }
}
