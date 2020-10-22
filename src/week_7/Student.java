package week_7;

public class Student implements Comparable<Student> {
    private int number; // 학번
    private String name; // 학생 이름
    private SortedLinkedList<Course> courseList;

    public Student(int number, String name, SortedLinkedList<Course> courseList) {
        this.number = number;
        this.name = name;
        this.courseList = courseList;
    }

    public int getTotalCredits() {
        int sum = 0;
        courseList.reset();
        while(courseList.hasNext())
            sum += courseList.next().getCredit();
        return sum;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.number, this.number);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.number).append("\t");
        sb.append(this.name).append("\t\t");
        sb.append("total credits: ").append(getTotalCredits()).append("\n");
        sb.append(this.courseList).append("\n");
        return sb.toString();
    }
}
