package clock;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 14001835
 */
public class ClockDisplay {

    private String displayString;   //What is displayed when the program is run
    private NumberDisplay hour = new NumberDisplay(24);
    private NumberDisplay minute = new NumberDisplay(60);
    private NumberDisplay second = new NumberDisplay(60);

    public ClockDisplay() {
        updateDisplay();
        setTime();
        timeTick();
        updateDisplay();
        timeTick();
        updateDisplay();
        timeTick();
        updateDisplay();

    }

    public void timeTick() {    //Runs the increment method for the seconds counter and only increments the minute counter or hour counter if neccessary
        second.increment();
        if (second.getValue() == 0) {
            minute.increment();
            if (minute.getValue() == 0) {
                hour.increment();
            }
        }

    }

    public void setTime() {
        //Gets the current time
        Calendar rightNow = Calendar.getInstance();
        int hourNow = rightNow.get(Calendar.HOUR_OF_DAY);
        int minuteNow = rightNow.get(Calendar.MINUTE);
        int secondNow = rightNow.get(Calendar.SECOND);
        //Sets the time values to the current time
        hour.setValue(hourNow);
        minute.setValue(minuteNow);
        second.setValue(secondNow);

    }

    public String getTime() {
        //Get the current time from the getValue method
        int newHour = hour.getValue();
        int newMinute = minute.getValue();
        int newSecond = second.getValue();
        //Formats the time to be 2 digits even if only 1 digit would be required
        //The hour is only formatted if the clock is a 24 hour clock
        DecimalFormat formatter = new DecimalFormat("00");
        //String hourFormatted = formatter.format(newHour);
        String minuteFormatted = formatter.format(newMinute);
        String secondFormatted = formatter.format(newSecond);
        if (newHour > 12) {
            displayString = (newHour - 12) + ":" + minuteFormatted + ":" + secondFormatted + " PM";
        } else {
            displayString = newHour + ":" + minuteFormatted + ":" + secondFormatted + " AM";
        }
        return displayString;
    }

    public void updateDisplay() {
        //Gets time, displays result
        getTime();
        System.out.println(displayString);
    }

}
