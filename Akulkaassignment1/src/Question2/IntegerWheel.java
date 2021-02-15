package Question2;
import Question1.Rollable;

public class IntegerWheel extends Wheel implements Rollable  {
    private int minValue, maxValue;
    //timer contrsuctor
    public IntegerWheel(int max)    {
    this.maxValue = max;
    this.setValue(max);
    }
    public IntegerWheel(int min, int max)   {
        this.minValue = min;
        this.maxValue = max;
        this.setValue(min);
    }


    @Override
    public void rollUp() {
        int temp = (int) this.getValue();
        temp++;
        this.setValue(temp);
    }

    @Override
    public void rollDown() {
        int temp1 = (int) this.getValue();
        temp1--;
        this.setValue(temp1);
    }

    @Override
    public void reset() {
        this.setValue(minValue);
    }
    //following method returns true if current value is greater than the previous
    @Override
    public Boolean isRolledOver() {
        if ((int)getValue() >= getMaxValue())
            return true;
        return false;
    }

    public int getMaxValue() {
        return maxValue;
    }
}

