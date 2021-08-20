package theater;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) throws Exception {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(int day) throws Exception {
        if (day > 0 && day < 32)
            this.day = day;
        else
            throw new Exception("Your day invalid!");
    }

    public void setMonth(int month) throws Exception {
        if (month > 0 && month < 13)
            this.month = month;
        else
            throw new Exception("Your month invalid!");
    }

    public void setYear(int year) throws Exception {
        if (year >= 1300)
            this.year = year;
        else
            throw new Exception("Your year invalid!");
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }
}
