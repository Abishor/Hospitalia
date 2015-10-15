package model;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.time.DayOfWeek;
import java.util.*;

public class Schedule {

    private final UUID id;
    private final List<Task> tasks;
    private final Map<DayOfWeek, List<Interval>> availabilityIntervals;

    public Schedule() {
        id = UUID.randomUUID();
        tasks = new LinkedList<Task>();

        availabilityIntervals = new HashMap<DayOfWeek, List<Interval>>();
    }


    public UUID getId() {
        return id;
    }

    public void addTask(final Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    public void removeTask(final UUID id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                tasks.remove(i);
                break;
            }
        }
    }

    public Map<DayOfWeek, List<Interval>> getAvailabilityIntervals() {
        return availabilityIntervals;
    }

    public List<Interval> getAvailabilityIntervals(final DayOfWeek dayOfWeek) {
        return availabilityIntervals.get(dayOfWeek);
    }

    public boolean isAvailable(final DateTime startTime, final Double requestedMinutes) {
        final DateTime endTime = startTime.plusMinutes(requestedMinutes.intValue());

        return isAvailable(startTime, endTime);
    }

    public boolean isAvailable(final DateTime startTime, final DateTime endTime) {

        if (availabilityIntervals.isEmpty()) {
            return false;
        } else {
            for (final Task currentTask : tasks) {
                if (currentTask.getInterval().contains(startTime.toInstant()) ||
                        currentTask.getInterval().contains(endTime.toInstant())) {
                    return false;
                }
            }
            final List<Interval> intervals = availabilityIntervals.get(DayOfWeek.of(startTime.getDayOfWeek()));
            if (intervals == null || intervals.isEmpty()) {
                return false;
            }
            for (final Interval interval : intervals) {
                if (interval.contains(startTime.toInstant()) && interval.contains(endTime.toInstant())) {
                    return true;
                }
                if (interval.contains(startTime.toInstant()) && !interval.contains(endTime.toInstant())
                        ||
                        !interval.contains(startTime.toInstant()) && interval.contains(endTime.toInstant())) {
                    return false;
                }
            }
        }
        return false;
    }
}
