package model;

import org.joda.time.DateTime;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public class Schedule {
    private final Integer id;
    private Visibility visibility;
    private List<Task> tasks;
    private Map<DayOfWeek, List<Map<DateTime, DateTime>>> availabilityIntervals;

    public Schedule(Integer id) {
        this.id = id;
    }


    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Map<DayOfWeek, List<Map<DateTime, DateTime>>> getAvailabilityIntervals() {
        return availabilityIntervals;
    }

    public void setAvailabilityIntervals(Map<DayOfWeek, List<Map<DateTime, DateTime>>> availabilityIntervals) {
        this.availabilityIntervals = availabilityIntervals;
    }

    public boolean isAvailable(final DateTime startInterval, final DateTime endInterval) {
        // TODO: implement logic
        return false;
    }
}
