package Question3;

import Question1.Rollable;
import Question2.Wheel;


public class WeekDaysWheel extends Wheel implements Rollable {

    private int dayOne, monthOne, yearOne;
    //implementing constructor methods
    public WeekDaysWheel(int day, int month, int year)  {
        this.dayOne = day;
        this.monthOne = month;
        this.yearOne = year;
        getWheel(day, year, month);
    }

    //implementing Zellers congruence to calculate weekday
    void getWheel(int day, int month, int year) {
        if (month < 3)  {
            month += 12;
            year -= 1;
        }

        int x = year/100;
        int y = year/100;

        int weekDay = ((day + (((month + 1) * 26) / 10) + y
                + (y / 4) + (x / 4)) + (5 * x)) % 7;
        setValue(weekDay);

    }
    //Rolling up by incrementing temp
    @Override
    public void rollUp() {
        int temp = (int)getValue();
        setValue(++temp);
    }
    //Rolling down by decrementing temp
    @Override
    public void rollDown() {
        int temp = (int)getValue();
        setValue(--temp);
    }
    //resetting to initial values
    @Override
    public void reset() {
        getWheel(dayOne, monthOne, yearOne);
    }
    //years font roll over in this program;
    @Override
    public Boolean isRolledOver() {
        return false;
    }

    //returning value from zellers congruence as a string.
    public String getString()   {
        if((int)getValue() == 0)
            return "Sat";
        else if((int)getValue() == 1)
            return "Sun";
        else if((int)getValue() == 2)
            return "Mon";
        else if((int)getValue() == 3)
            return "Tue";
        else if((int)getValue() == 4)
            return "Wed";
        else if((int)getValue() == 5)
            return "Thu";
        else
            return "Fri";
    }

}
