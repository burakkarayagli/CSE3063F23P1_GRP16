package interfaces;

import java.util.ArrayList;

import models.Lecturer;
import models.TimeInterval;

public interface SectionInterface {
    public boolean isTechnical();

    public boolean isMandatory();

    public void setDates(ArrayList<TimeInterval> dates);

    public ArrayList<TimeInterval> getDates();

    public boolean addDate(TimeInterval date);

    public boolean removeDate(TimeInterval date);

    public String getSectionName();

    public void setSectionName(String sectionName);

    public Lecturer getLecturer();

    public void setLecturer(Lecturer lecturer);

    public int getQuota();

    public void setQuota(int quota);
}