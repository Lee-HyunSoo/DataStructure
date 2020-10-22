package week_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        String command;
        int item;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: push, pop, peek, size, p(rint) or q(uit)");
        System.out.print("> ");
        command = in.next();

        while (true) {
            if (command.equals("e")) {
                item = in.nextInt();
                queue.enqueue(item);
            } else if (command.equals("d")) {
                queue.dequeue();
            } else if (command.equals("s"))
                System.out.println("Size: " + queue.size());
            else if (command.equals("peek"))
                System.out.println("Front of the queue: " +
                        queue.peek());
            else if (command.equals("p"))
                System.out.println(queue);
            else if (command.equals("c"))
                checkWord();
            else if (command.equals("q")) {
                System.out.println("-- End --");
                break;
            }
            System.out.print("> ");
            command = in.next();
        }
        in.close();
    }

    public static void checkWord() throws FileNotFoundException {
        ArrayQueue<Integer> intQueue = new ArrayQueue<>();
        ArrayQueue<String> strQueue = new ArrayQueue<>();
        ArrayQueue<Double> doubleQueue = new ArrayQueue<>();
        Scanner inFile = new Scanner(new File("./input/week_5 input.txt"));

        while(inFile.hasNext()) {
            String line = inFile.next();
            if (isInteger(line))
                intQueue.enqueue(Integer.parseInt(line));
            else if (isDouble(line))
                doubleQueue.enqueue(Double.parseDouble(line));
            else
                strQueue.enqueue(line);
        }

        System.out.println("Integer: " + intQueue);
        System.out.println("Double: " + doubleQueue);
        System.out.println("String: " + strQueue);
    }

    public static boolean isDouble(String line) {
        int cnt = 0;
        for (int i = 0; i < line.length(); i++) {
            char data = line.charAt(i);
            if (data == '.')
                cnt++;
            else if (data < '0' || data > '9')
                return false;
        }
        return cnt <= 1;
    }

    public static boolean isInteger(String line) {
        for (int i = 0; i < line.length(); i++) {
            char data = line.charAt(i);
            if (data < '0' || data > '9')
                return false;
        }
        return true;
    }
}
