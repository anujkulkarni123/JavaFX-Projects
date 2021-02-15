package Question2;
import java.text.DecimalFormat;
import java.util.Random;
import Question1.CounterDisplay;

public class IntegerWheelCounter implements CounterDisplay  {

    //Initializing number of wheels, 3 wheels on a clock
    private int numOfWheels = 3;

    //Initializing Array of wheels
    IntegerWheel[] integerWheel = new IntegerWheel[numOfWheels];

    public IntegerWheelCounter(IntegerWheel wheelThree, IntegerWheel wheelTwo, IntegerWheel wheelOne) {
       //assigning wheels to array
       this.integerWheel[0] = wheelThree;
       this.integerWheel[1] = wheelTwo;
       this.integerWheel[2] = wheelOne;
    }

    @Override
    public void reset() {
        //parses through each wheel and resets it
        for (int i = 0; i < integerWheel.length; i++)   {
            integerWheel[i].reset();
        }
    }

    @Override
    public void shuffle() {
        //initializing random scanner, and setting wheels to display random numbers between (0,respective-bound)
        Random rand = new Random();
        integerWheel[0].setValue(rand.nextInt(23));//hours
        integerWheel[1].setValue(rand.nextInt(59));//minutes
        integerWheel[2].setValue(rand.nextInt(59));//Seconds
    }

    @Override
    public void increase() {
        //triggering rollup method for seconds
        integerWheel[2].rollUp();

        if  (integerWheel[2].isRolledOver())    {
            integerWheel[1].rollUp();
            integerWheel[2].reset();
        }
        if  (integerWheel[1].isRolledOver())    {
            integerWheel[0].rollUp();
            integerWheel[1].reset();
        }

    }

    @Override
    public void decrease() {
        integerWheel[2].rollDown();
    }

    public String toString()    {
        DecimalFormat df = new DecimalFormat("00");
        String a = df.format(integerWheel[0].getValue());
        String b = df.format(integerWheel[1].getValue());
        String c = df.format(integerWheel[2].getValue());
        return a + ":" + b + ":" + c;
    }
}
