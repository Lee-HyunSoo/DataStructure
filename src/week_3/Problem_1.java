package week_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) throws FileNotFoundException {
        int year, month, day;
        Date date;
        Node headFirst = null;
        Node headLast = null;
        Node headOrder = null;

        Scanner inFile = new Scanner(new File("./input/week_3 input.txt"));
        while (inFile.hasNextLine()) {
            year = inFile.nextInt();
            month = inFile.nextInt();
            day = inFile.nextInt();
            date = new Date(year, month, day);
            headFirst = insertFirst(headFirst, date);
            headLast = insertLast(headLast, date);
            headOrder = insertSortedOrder(headOrder, date);
        }
        inFile.close();
        System.out.println("Insertion in first: ");
        print(headFirst);
        System.out.println(("Insertion in last: "));
        print(headLast);
        System.out.println("Insertion in sorted order: ");
        print(headOrder);
    }

    public static void print(Node head) {
        Node scan = head;
        while (scan!=null) {
            System.out.println(scan.item);
            scan = scan.next;
        }
        System.out.println();
    }

    public static Node insertFirst(Node headFirst, Date date) {
        if (headFirst == null) {
            headFirst = new Node(date);
        } else {
            Node newNode = new Node(date, headFirst);
            headFirst = newNode;
        }
        return headFirst;
    }

    public static Node insertLast(Node headLast, Date date) {
        if (headLast == null)
            headLast = new Node(date);
        else {
            Node scan = headLast;
            while (scan.next != null)
                scan = scan.next;
            Node newNode = new Node(date);
            scan.next = newNode;
        }
        return headLast;
    }

    public static Node insertSortedOrder(Node headOrder, Date date) {
        if (headOrder == null)
            headOrder = new Node(date);
        else {
            Node prev = null;
            Node curr = headOrder;
            while (curr != null) {
                if (curr.item.compareTo(date) == 1) break;
                prev = curr;
                curr = curr.next;
            }
            Node newNode = new Node(date);
            newNode.next = curr;
            if (prev == null)
                headOrder = newNode;
            else
                prev.next = newNode;
        }
        return headOrder;
    }
}
