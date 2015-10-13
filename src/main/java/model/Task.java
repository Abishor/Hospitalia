package model;

import org.joda.time.DateTime;

public class Task {
    private final Integer id;
    private String description;
    private Individual solicitor;
    private Individual handler;
    private DateTime startTime;
    private DateTime endTime;


    public Task(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Individual getSolicitor() {
        return solicitor;
    }

    public void setSolicitor(Individual solicitor) {
        this.solicitor = solicitor;
    }

    public Individual getHandler() {
        return handler;
    }

    public void setHandler(Individual handler) {
        this.handler = handler;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }
}
