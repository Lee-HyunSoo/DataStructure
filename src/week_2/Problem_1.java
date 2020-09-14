package week_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Date[] dates = new Date[50];
        int idx = 0;
        Scanner inFile = new Scanner(new File("./input/week_2 input.txt"));

        System.out.println("Birthdays : ");
        while(inFile.hasNextLine()) {
            dates[idx++] = new Date(inFile.nextInt(), inFile.nextInt(), inFile.nextInt());
            System.out.println(dates[idx - 1].toString());
        }
        Date earlist = dates[0];
        Date lastest = dates[0];
        for (int i = 1; i < idx; i++) {
            if (earlist.compareTo(dates[i]) == 1) earlist = dates[i];
            if (lastest.compareTo(dates[i]) == -1) lastest = dates[i];
        }
        System.out.println("Earlist birthday : " + earlist.toString());
        System.out.println("lastest birthday : " + lastest.toString());

        inFile.close();
        inFile = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a birthday : ");
            int year = inFile.nextInt();
            int month = inFile.nextInt();
            int day = inFile.nextInt();

            if (year == 0 && month == 0 && day == 0) break;

            Date temp = new Date(year, month, day);
            int cnt = 0;
            for (int i = 0; i < idx; i++) {
                if (temp.equals(dates[i])) cnt++;
            }
            System.out.println("Number of the same birthday : " + cnt);
        }
        System.out.println("-- End --");
    }
}
