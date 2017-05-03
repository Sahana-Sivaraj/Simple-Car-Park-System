import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by hp on 1/8/2017.
 */
public class DateTime {
    int day;
    int month;
    int year;
    int hour;
    int minute;
    String datetime;
    java.util.Date date1;
    public DateTime(String datetime) {
        this.datetime = datetime;
        this.date1=this.datetime(datetime);
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public java.util.Date datetime(String date){

        DateFormat format = new SimpleDateFormat("yyyy:mm:dd:hh:mm:ss", Locale.ENGLISH);
        java.util.Date date1=null;
        try {
           this.date1 = format.parse(date);
        } catch (ParseException e) {

            e.printStackTrace();
        }

        return this.date1;
    }
    public int calculateHour(java.util.Date date){
        int hour =0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        hour=calendar.get(Calendar.HOUR);
        return hour;
    }
    public int calculateDay(java.util.Date date){
        int day=0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        day=calendar.get(Calendar.DATE);
        return day;
    }
    public int calculateYear(java.util.Date date){
        int year=0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        year=calendar.get(Calendar.YEAR);
        return year;
    }
    public static long differenceHours(Date date1,Date date2){
        long diff=date1.getTime()-date2.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long elapsedHours = diff / hoursInMilli;
        diff = diff % hoursInMilli;
        return elapsedHours;
    }
}
