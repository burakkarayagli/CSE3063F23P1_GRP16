import java.text.SimpleDateFormat;
import java.util.Date;
public class TimeInterval {
    private int id;
    private String startTime;
    private String endTime;
    private String dayOfWeek;

    public TimeInterval(int id, String startTime, String endTime, String dayOfWeek) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }

    public TimeInterval(int id, String startTime, String endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeInterval(int id, String startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public TimeInterval(int id) {
        this.id = id;
    }

    public TimeInterval() {
    }

    public int getId() {
        return id;
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

    public int getTotalTimeInMinutes() {
        
        //Convert start and end time to Date objects(HH:MM)
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date start = format.parse(startTime);
        Date end = format.parse(endTime);

        //Get difference between start and end time in minutes
        long difference = end.getTime() - start.getTime();
        int minutes = (int) (difference / (1000 * 60));
        return minutes;
    }

    public String getTimeIntervalInfo() {
        return "TimeInterval{" + "id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", dayOfWeek=" + dayOfWeek + '}';
    }
}
