package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class TimeInterval {
    private String startTime;
    private String endTime;
    private String dayOfWeek;

    public TimeInterval(String startTime, String endTime, String dayOfWeek) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }

    public TimeInterval(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeInterval() {
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String start) {
        this.startTime = start;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String end) {
        this.endTime = end;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String day) {
        this.dayOfWeek = day;
    }

    public int getTotalTimeInMinutes() throws ParseException {
        try {
            // Convert start and end time to Date objects(HH:mm)
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date start = format.parse(startTime);
            Date end = format.parse(endTime);

            // Get difference between start and end time in minutes
            long difference = end.getTime() - start.getTime();
            int minutes = (int) (difference / (1000 * 60));

            return minutes;
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getTimeIntervalInfo() {
        return "TimeInterval{" + "startTime=" + startTime + ", endTime=" + endTime + ", dayOfWeek=" + dayOfWeek + '}';
    }
}
