package Question3;

import Question1.CounterDisplay;

import java.util.Random;
import java.util.stream.IntStream;

public class CalendarCounter implements CounterDisplay {

    private DayWheel dayWheel;
    private MonthWheel monthWheel;
    private WeekDaysWheel weekDaysWheel;
    private YearWheel yearWheel;

    CalendarCounter(int initialMonth, int initialDay, int initialYear)    {
        this.dayWheel = new DayWheel(initialDay, initialMonth);
        this.monthWheel = new MonthWheel(initialMonth);
        this.yearWheel = new YearWheel(initialYear);
        this.weekDaysWheel = new WeekDaysWheel(initialDay, initialMonth, initialYear);
    }

    @Override
    public void reset() {
        dayWheel.reset();
        monthWheel.reset();
        yearWheel.reset();
        weekDaysWheel.reset();

    }

    @Override
    public void shuffle() {
        //Understood that this method is unnecessary for this project, I made this just for fun.
        //Assigning random values to the years and months from 1 to respective limits
        Random rand = new Random();
        monthWheel.setValue(rand.nextInt(12+1));
        yearWheel.setValue(rand.nextInt(2021+1));

        //Assigning number of days to their corresponding months
        if (IntStream.of(1, 3, 5, 7, 8, 10, 12).anyMatch(i -> (int) monthWheel.getValue() == i))    {
            dayWheel.setValue(rand.nextInt(31+1)); //range 1-31
        } else if ((int)monthWheel.getValue() == 2 && yearWheel.isLeapYear() == false)  {
            dayWheel.setValue(rand.nextInt(28+1));//range 1-28
        } else if ((int)monthWheel.getValue() == 2 && yearWheel.isLeapYear() == true)    {
            dayWheel.setValue(rand.nextInt(29+1));//range 1-29
        } else {
            dayWheel.setValue(rand.nextInt(30+1));//range 1-30
        }
        //assigning each wheel to the weekday wheel
        weekDaysWheel.getWheel((int)dayWheel.getValue(), (int)monthWheel.getValue(), (int)yearWheel.getValue());


    }

    @Override
    public void increase() {
        //implementing rollup methods to
        weekDaysWheel.rollUp();
        if  (monthWheel.getLength() == 31)  {
            dayWheel.setValue((int)dayWheel.getValue()+1);
            if ((int)dayWheel.getValue() == 31) {
                dayWheel.rollUp();
                monthWheel.rollUp();
            }
        }
        if (monthWheel.getLength() == 30)   {
            dayWheel.setValue((int)dayWheel.getValue()+1);
            if ((int)dayWheel.getValue() >= 30) {
                dayWheel.rollUp();
                monthWheel.rollUp();
            }
        }
        if(monthWheel.getLength() == 28)    {
            if(yearWheel.isLeapYear() == true)   {
                dayWheel.setValue((int)dayWheel.getValue() + 1);
                if((int)dayWheel.getValue() > 29)   {
                    dayWheel.rollUp();
                    monthWheel.rollUp();
                }
            }
            else    {
                dayWheel.setValue((int)dayWheel.getValue() + 1);
                if((int)dayWheel.getValue() > 28)   {
                    dayWheel.rollUp();
                    monthWheel.rollUp();
                }
            }
        }
    }

    @Override
    public void decrease() {
        weekDaysWheel.rollDown();
        dayWheel.setValue((int)dayWheel.getValue() - 1);
        if((int)dayWheel.getValue() < 1)    {
            monthWheel.rollDown();
            if(yearWheel.isLeapYear() == true) {
                dayWheel.setValue(29);
            } else {
                dayWheel.rollDown();
            }
        }
    }

    public String toString()  {
        return weekDaysWheel.getString() + " " + dayWheel.getValue() + " " + monthWheel.getMonth()
                + ", " + yearWheel.getValue();
    }

}
