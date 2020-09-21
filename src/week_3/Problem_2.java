package week_3;

import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a row number : ");
            int row = scan.nextInt();

            if(row == 0) break;

            Node_2[] pascal = new Node_2[row];

            makeTriangle(pascal);
            print(pascal);

        }
        scan.close();
        System.out.println("-- End --");
    }

    public static void makeTriangle(Node_2[] pascal) {
        for (int i = 0; i < pascal.length; i++) {
            pascal[i] = new Node_2(1);
            Node_2 prev = pascal[i];

            for (int j = 2; j <= i + 1; j++) {
                if (j == i + 1)
                    prev.next = new Node_2(1);
                else {
                    int currNum = selectN(pascal[i - 1], j - 1).item + selectN(pascal[i - 1], j).item;
                    prev.next = new Node_2(currNum);
                }
                prev = prev.next;
            }
        }
    }
    public static Node_2 selectN(Node_2 head, int n) {
        Node_2 temp = head;
        for (int i = 1; i < n; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void print(Node_2[] head) {
        for (int i = 0; i < head.length; i++) {
            Node_2 temp = head[i];

            while(temp != null) {
                System.out.print((temp.item + "\t"));
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
