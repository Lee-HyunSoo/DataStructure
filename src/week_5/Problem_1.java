package week_5;

import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        String command;
        int item;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: e(nqueue), d(equeue), s(ize), peek, sort, p(rint), or q(uit)");
        System.out.print("> ");
        command = in.next();

        while (true) {
            if (command.equals("e")) {
                item = in.nextInt();
                queue.enqueue(item);
            }
            else if (command.equals("d")) {
                queue.dequeue();
            }
            else if (command.equals("s"))
                System.out.println("Size: " + queue.size());
            else if (command.equals("peek"))
                System.out.println("Front of the queue: " +
                        queue.peek());
            else if (command.equals("p"))
                System.out.println(queue);
            else if (command.equals("sort"))
                radixSort();
            else if (command.equals("q")) {
                System.out.println("-- End --");
                break;
            }
            System.out.print("> ");
            command = in.next();
        }
        in.close();
    }

    public static void radixSort() {
        final int MAX_ITEMS = 20;
        Integer[] items = new Integer[MAX_ITEMS];
        for (int i = 0; i < items.length; i++) {
            items[i] = (int) (10000.0 * Math.random());
        }
        System.out.print("정렬되지 않은 데이터: ");
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();

        int radix = 10;
        LinkedQueue<Integer>[] queues = new LinkedQueue[radix];
        for (int i = 0; i < radix; i++) {
            queues[i] = new LinkedQueue<Integer>();
        }

        System.out.print("1자리 정렬: \t\t  ");
        for (int i = 0; i < items.length; i++) {
            queues[items[i] % 10].enqueue(items[i]);
        }
        printQueue(items, queues);

        System.out.print("10자리 정렬: \t\t  ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] < 10)
                queues[0].enqueue(items[i]);
            else
                queues[(items[i] % 100) / 10].enqueue(items[i]);
        }
        printQueue(items, queues);

        System.out.print("100자리 정렬: \t  ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] < 100)
                queues[0].enqueue(items[i]);
            else
                queues[(items[i] % 1000) / 100].enqueue(items[i]);
        }
        printQueue(items, queues);

        System.out.print("1000자리 정렬: \t  ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] < 1000)
                queues[0].enqueue(items[i]);
            else
                queues[items[i] / 1000].enqueue(items[i]);
        }
        printQueue(items, queues);
    }

    public static void printQueue(Integer[] items, LinkedQueue<Integer>[] queues) {
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            while(!queues[i].isEmpty()) {
                items[idx] = queues[i].dequeue();
                System.out.print(items[idx] + " ");
                idx++;
            }
        }
        System.out.println();
    }
}
