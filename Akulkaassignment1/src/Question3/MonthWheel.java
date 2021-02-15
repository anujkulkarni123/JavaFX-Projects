package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class MonthWheel extends Wheel implements Rollable {

    private int monthOne;
    public MonthWheel(int value) {
        //constructor for month
        this.monthOne = value;
        setValue(monthOne);
    }

    @Override //Rolls up the month by one
    public void rollUp() {
        int temp = (int)getValue();
        setValue(++temp);

    }

    @Override //rolls down month by one
    public void rollDown() {
        int temp = (int)getValue();
        setValue(--temp);
    }

    @Override
    public void reset() {
        setValue(monthOne);
    }

    @Override //returns whether or not monthwheel is rolled over
    public Boolean isRolledOver() {
        if (getLength() == monthOne)
            return false;
        return true;
    }
    //Assigning months of type string to the month values
    public String getMonth()    {
        if((int)getValue() == 1)
            return "Jan";
        if((int)getValue() == 2)
            return "Feb";
        if((int)getValue() == 3)
            return "Mar";
        if((int)getValue() == 4)
            return "Apr";
        if((int)getValue() == 5)
            return "May";
        if((int)getValue() == 6)
            return "Jun";
        if((int)getValue() == 7)
            return "Jul";
        if((int)getValue() == 8)
            return "Aug";
        if((int)getValue() == 9)
            return "Sep";
        if((int)getValue() == 10)
            return "Oct";
        if((int)getValue() == 11)
            return "Nov";
        if((int)getValue() == 12)
            return "Dec";
        return null;
    }
    //returns a certain month-length based on the month of the year
    public int getLength()  {
        if((int)getValue() == 1 || (int)getValue() == 3 || (int)getValue() == 5 ||
                (int)getValue() == 7 || (int)getValue() == 8 || (int)getValue() == 10 ||
                (int)getValue() == 12) {
            return 31;
        } else if ((int)getValue() == 2) {
            return 28;
        } else {
            return 30;
        }
    }

}
