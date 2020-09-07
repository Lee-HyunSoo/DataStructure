package Week_1;

import Week_1.Date;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./input/week_1 input.txt");
        Scanner scan = new Scanner(new FileInputStream(file));

        while (scan.hasNextLine()) {
            Date date = new Date(scan.nextInt(), scan.nextInt(), scan.nextInt());

            System.out.print(date.getYear() + " : ");
            if (date.isLeap())
                System.out.println("윤년");
            else
                System.out.println("평년");
        }
    }
}