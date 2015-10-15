package model.hospital.resources;

import model.Schedule;
import model.transactions.Request;
import model.transactions.Response;
import org.joda.time.DateTime;

import java.util.UUID;

public class Equipment<T> implements Resource {

    private final UUID id;
    private T data;
    private final Schedule schedule;

    public Equipment(final T data) {
        id = UUID.randomUUID();
        this.data = data;
        schedule = new Schedule();
    }

    public UUID getId() {
        return id;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    boolean getAvailability(final DateTime startTime, final DateTime endTime) {
        if (endTime.isBefore(startTime.toInstant())) {
            return false;
        } else {
            final Double diffInMin = (double) (endTime.getMillis() - startTime.getMillis()) / (1000 * 60);
            return schedule.isAvailable(startTime, diffInMin);
        }
    }

    public Response request(final Request request) {
        return null;
    }

    public Response cancel(final Integer identifier) {
        return null;
    }

    public Double getCost(final Request request) {
        return null;
    }
}
