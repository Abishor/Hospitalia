package model.hospital.resources;

import model.transactions.Request;
import model.transactions.Response;

public class Room implements Resource {
    public Response request(Request request) {
        return null;
    }

    public Response cancel(Integer identifier) {
        return null;
    }

    public Double getCost(Request request) {
        return null;
    }
}
