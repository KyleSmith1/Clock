package clock;

/**
 * @author 14001835
 */
public class NumberDisplay {

    private int limit;
    private int value;

    public NumberDisplay(int newLimit) {
        //Sets the max number for that unit of time e.g. second, minutes = 60, hours = 24
        limit = newLimit;
    }

    public int getValue() {
        //Returns the value for that unit of time
        return value;
    }

    private void displayValue() {
        System.out.println(value);
    }

    public void setValue(int replacementValue) {
        //Accepts a number and sets the value to that new number
        value = replacementValue;
    }

    public void increment() {
        //Increments the value by 1 and if the value reaches its limit, resets the value to 0
        value = value + 1;
        if (value >= limit) {
            value = 0;
        }
        //Sets the value
        setValue(value);
    }
}
