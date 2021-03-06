package week_4;

import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        String command;
        int item;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: push, pop, peek, size, " +
                "b(conversion decimal to binary), p(rint) or q(uit)");
        System.out.print("> ");
        command = in.next();

        while (true) {
            if (command.equals("push")) {
                item = in.nextInt();
                stack.push(item);
            }
            else if (command.equals("pop")) {
                stack.pop();
            }
            else if (command.equals("peek")) {
                item = stack.peek();
                System.out.println("Top element is " + item);
            }
            else if (command.equals("size")) {
                System.out.println("Size: " + stack.size());
            }
            else if (command.equals("p"))
                System.out.println(stack);
            else if (command.equals("b"))
                convertDecimalToBinary(in);

            else if (command.equals("q")) {
                System.out.println("-- End --");
                break;
            }
            System.out.print("> ");
            command = in.next();
        }
        in.close();
    }

    public static void convertDecimalToBinary(Scanner in) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        while(true) {
            System.out.print("Enter a deciaml number: ");
            int n = in.nextInt();

            if (n == 0)
                return;

            System.out.print(n + " ==> ");
            while (n > 0) {
                stack.push(n % 2);
                n /= 2;
            }

            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }
}
