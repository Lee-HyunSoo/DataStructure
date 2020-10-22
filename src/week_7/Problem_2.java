package week_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("./input/week7_input.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file: week7_input.txt" );
        }

        SortedLinkedList<Student> studentList = new SortedLinkedList<>();
        // inFile에서 학생 데이터 읽어 studentList에 저장
        getStudentData(inFile, studentList);
        System.out.print(studentList);
        inFile.close();
    }

    public static void getStudentData(Scanner inFile, SortedLinkedList<Student> studentList) {
        while (inFile.hasNextLine()) {
            String[] student = inFile.nextLine().split(" ");
            SortedLinkedList<Course> courseList = new SortedLinkedList<>();

            while (inFile.hasNextLine()) {
                String course = inFile.nextLine();
                if (course.equals(""))
                    break;
                String[] data = course.split(" ");
                courseList.insert(new Course(data[0], Integer.parseInt(data[1]), data[2].charAt(0)));
            }
            studentList.insert(new Student(Integer.parseInt(student[0]), student[1], courseList));
        }
    }
}
