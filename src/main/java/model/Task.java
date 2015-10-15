package model;

import model.hospital.resources.Staff;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public final class Task {
    private final UUID id;
    private final Patient solicitor;
    private final Set<Staff> handlers;
    private final DateTime startTime;
    private final DateTime endTime;

    private final List<String> notes;

    private Task(final Patient solicitor, final Set<Staff> handlers, final DateTime startTime, final DateTime endTime) {
        id = UUID.randomUUID();
        this.solicitor = solicitor;
        this.handlers = handlers;
        this.startTime = startTime;
        this.endTime = endTime;
        notes = new LinkedList<String>();
    }

    public UUID getId() {
        return id;
    }

    public Patient getSolicitor() {
        return solicitor;
    }

    public Set<Staff> getHandlers() {
        return handlers;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void addNote(final String note) {
        notes.add(note);
    }

    public void addNotes(final List<String> notes) {
        this.notes.addAll(notes);
    }

    public void addHandler(final Staff handler) {
        checkNotNull(handler, "A handler must be specified");
        handlers.add(handler);
    }

    public void removeHandler(final Staff handler) {
        handlers.remove(handler);
    }

    /**
     * Get the number of minutes
     */
    public Double getDuration() {
        return ((double) endTime.getMillis() - startTime.getMillis()) / 1000 * 60;
    }

    public Interval getInterval() {
        return new Interval(startTime, endTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Task task = (Task) o;

        return id.equals(task.id);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + notes.hashCode();
        result = 31 * result + solicitor.hashCode();
        result = 31 * result + (handlers != null ? handlers.hashCode() : 0);
        result = 31 * result + startTime.hashCode();
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }


    public static class Builder {
        private Patient solicitor;
        private Set<Staff> handler;
        private DateTime startTime;
        private DateTime endTime;
        private Long duration;
        private List<String> notes;

        public Task build() {
            checkNotNull(startTime, "A start time must be specified");
            checkArgument(endTime != null || duration != null, "A reservation time must be specified");
            if (endTime == null) {
                endTime = startTime.plusMinutes(duration.intValue());
            }
            checkArgument(startTime.isBefore(endTime.toInstant()), "Invalid time intervals");
            checkNotNull(solicitor, "An appointment must have a solicitor reference");

            final Task newTask = new Task(solicitor, handler, startTime, endTime);

            if (notes != null && !notes.isEmpty()) {
                newTask.addNotes(this.notes);
            }
            return newTask;
        }

        public Builder setNotes(final List<String> notes) {
            this.notes = notes;
            return this;
        }

        public Builder setSolicitor(final Patient solicitor) {
            this.solicitor = solicitor;
            return this;
        }

        public Builder setHandler(final Set<Staff> handler) {
            this.handler = handler;
            return this;
        }

        public Builder setStartTime(final DateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(final DateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setDuration(final Long duration) {
            this.duration = duration;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", notes='" + notes + '\'' +
                ", solicitor=" + solicitor +
                ", handlers=" + handlers +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
