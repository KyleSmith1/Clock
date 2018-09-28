package clock;

import java.util.Calendar;

/**
 * @author 14001835
 */
public class NumberDisplay {

    private int limit;
    private int value;

    public NumberDisplay(int newLimit) {
        limit = newLimit;

    }

    public int getValue() {

        return value;
    }

    private void displayValue() {
        System.out.println(value);
    }

    public void setValue(int replacementValue) {
        value = replacementValue;
    }

    public void increment() {
        value = value + 1;
        if (value >= limit) {
            value = 0;
        }
        setValue(value);
    }
}
