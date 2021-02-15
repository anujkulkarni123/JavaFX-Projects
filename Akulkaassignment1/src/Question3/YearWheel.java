package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class YearWheel extends Wheel implements Rollable {

    private int year;
    //yearWheel constructor
    public YearWheel(int value)  {
        this.year = value;
        setValue(year);
    }
    // Unnecessary methods
    @Override
    public void rollUp() {

    }
    //Unnecessary methods
    @Override
    public void rollDown() {

    }
    //unnecessary methods
    @Override
    public void reset() {

    }
    //Returns false value because year does not change
    @Override
    public Boolean isRolledOver() {
        return false;
    }
    //verifies if year is leap year by checking divisibility by 400 and 4, but excludes centuries.
    public boolean isLeapYear() {
        if((int)getValue() % 400 == 0)
            return true;
        if((int)getValue()% 100 == 0)
            return false;
        return (int) getValue() % 4 == 0;
    }

}
