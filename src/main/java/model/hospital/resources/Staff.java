package model.hospital.resources;

import model.Person;
import model.Schedule;
import model.StaffType;
import model.transactions.Request;
import model.transactions.Response;
import model.transactions.StandardRequest;
import org.apache.http.HttpStatus;
import org.joda.time.Interval;

public class Staff extends Person<Staff.Data> implements Resource {
    private StaffType type;
    private Staff.Data data;
    private Schedule schedule;

    public Staff(final String name) {
        super(name);
        schedule = new Schedule();
    }

    public StaffType getType() {
        return type;
    }

    public void setType(final StaffType type) {
        this.type = type;
    }

    public Response<String> checkAvailability(final Interval interval) {
        if (isAvailable(interval)) {
            return new Response<String>(HttpStatus.SC_OK, "Availability precondition passed.");
        } else {
            return new Response<String>(HttpStatus.SC_PRECONDITION_FAILED, "No availability for the provided interval");
        }
    }

    public Response request(final Request request) {
        // TODO
        if (request instanceof StandardRequest) {
            final StandardRequest standardRequest = (StandardRequest) request;
            final Interval solicitedInterval = standardRequest.getData().getInterval();

        }
        return null;
    }

    private boolean isAvailable(final Interval interval) {
        return schedule.isAvailable(interval.getStart(), interval.getEnd());
    }

    public Response cancel(final Integer identifier) {
        return null;
    }

    public Double getCost(final Request request) {
        // TODO: compute base rate vs time required
        return 1.1;
    }

    public Staff.Data getData() {
        return data;
    }

    public void setData(final Staff.Data data) {
        this.data = data;
    }

    public static class Data {
        private final Double baseCost;

        public Data(final Double baseCost) {
            this.baseCost = baseCost;
        }

        public Double getBaseCost() {
            return baseCost;
        }
    }
}
