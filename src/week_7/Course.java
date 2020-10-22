package week_7;

public class Course implements Comparable<Course> {
    private String name; // 강의 이름
    private int credit; // 학점 수
    private char grade; // 성적

    public Course(String name, int credit, char grade) {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }
    public int getCredit() {
        return this.credit;
    }
    public char getGrade() {
        return this.grade;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.getName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\t%-20s", name));
        sb.append(String.format("\t%8d", credit));
        sb.append(String.format("\t%7s", grade));
        sb.append("\n");
        return sb.toString();
    }
}
