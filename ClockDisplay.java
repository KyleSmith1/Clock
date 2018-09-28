package clock;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 14001835
 */
public class ClockDisplay {

    private String displayString;
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

    public void timeTick() {
        second.increment();
        if (second.getValue() == 0) {
            minute.increment();
            if (minute.getValue() == 0) {
                hour.increment();
            }
        }

    }

    public void setTime() {

        Calendar rightNow = Calendar.getInstance();
        int hourNow = rightNow.get(Calendar.HOUR_OF_DAY);
        int minuteNow = rightNow.get(Calendar.MINUTE);
        int secondNow = rightNow.get(Calendar.SECOND);
        hour.setValue(hourNow);
        minute.setValue(minuteNow);
        second.setValue(secondNow);
        DecimalFormat formatter = new DecimalFormat("00");
        String hourFormatted = formatter.format(hourNow);
        String minuteFormatted = formatter.format(minuteNow);
        String secondFormatted = formatter.format(secondNow);

    }

    public String getTime() {
        int newHour = hour.getValue();
        int newMinute = minute.getValue();
        int newSecond = second.getValue();
        DecimalFormat formatter = new DecimalFormat("00");
        //String hourFormatted = formatter.format(newHour);
        String minuteFormatted = formatter.format(newMinute);
        String secondFormatted = formatter.format(newSecond);
        if(newHour > 12){
            displayString = (newHour-12) + ":" + minuteFormatted + ":" + secondFormatted + " PM";
        }
        else{
            displayString = newHour + ":" + minuteFormatted + ":" + secondFormatted + " AM";
        }
        return displayString;
    }

    public void updateDisplay() {

        getTime();
        System.out.println(displayString);
    }

}
