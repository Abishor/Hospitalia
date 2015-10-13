package model.hospital.resources;

import model.transactions.Request;
import model.transactions.Response;

public interface Resource {
    Response request(Request request);
    Response cancel(Integer identifier);
    Double getCost(Request request);
}
