package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class DayWheel extends Wheel implements Rollable {

    private int month, dayOne;
    public DayWheel(int Day, int Month) {
        this.month = Month;
        this.dayOne = Day;
        setValue(Day);
    }
    //setting value for first day of month
    @Override
    public void rollUp() {
        setValue(1);
    }
    //setting values for last day of the month
    @Override
    public void rollDown() {
        if(month == 12 || month == 10 || month == 7 || month == 5)
            setValue(30);
        else if(month == 11 || month == 9 || month == 6 || month == 1 || month == 8)
            setValue(31);
        else
            setValue(28);
    }
    //resetting to the initial day
    @Override
    public void reset() {
        setValue(dayOne);
    }
    //returning false for isRolledOver
    @Override
    public Boolean isRolledOver() {
        return false;
    }

}
