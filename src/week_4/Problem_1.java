package week_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayStack<Integer> stack = new ArrayStack<>();
        String command;
        int item;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: push, pop, peek, size, p(rint) or q(uit)");
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
            else if (command.equals("m"))
                checkParenthesis();
            else if (command.equals("q")) {
                System.out.println("-- End --");
                break;
            }
            System.out.print("> ");
            command = in.next();
        }
        in.close();
    }

    public static void checkParenthesis() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("./input/week_4 input.txt"));
        ArrayStack<Character> stack = new ArrayStack<>();

        Loop: // 반복문의 이름
        while (inFile.hasNextLine()) {
            stack.clear();
            String line = inFile.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char data = line.charAt(i); // line[i]
                System.out.print(data);

                char check;
                switch (data) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(data);
                        continue; // for문에 대한 continue
                    case ')':
                        check = '(';
                        break;
                    case '}':
                        check = '{';
                        break;
                    case ']':
                        check = '[';
                        break;
                    default:
                        continue;
                }
                if (stack.isEmpty()) {
                    System.out.println("\nClosing parenthesis is not matched.\n");
                    continue Loop;
                }
                if (stack.pop() != check) {
                    System.out.println("\nparenthesis is not matched.\n");
                    continue Loop;
                }
            }
            if (!stack.isEmpty())
                System.out.println("\nOpening parenthesis is not matched.\n");
            else
                System.out.println("\nParentheses matched.\n");
        }
    }
}
