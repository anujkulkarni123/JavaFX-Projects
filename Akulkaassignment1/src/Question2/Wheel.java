package Question2;

public abstract class Wheel<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value; }

    public abstract void reset();

    public abstract Boolean isRolledOver();

}
