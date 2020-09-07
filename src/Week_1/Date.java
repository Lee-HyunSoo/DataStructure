package Week_1;

public class Date {
    private int year;
    private int month;
    private int day;
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public boolean isLeap() {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        else return false;
    }
    public int getYear() {return year;}
    public int getMonth() {return month;}
    public int getDay() {return day;}
}