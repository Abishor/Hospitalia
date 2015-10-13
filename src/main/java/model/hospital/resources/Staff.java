package model.hospital.resources;

import model.Department;
import model.Individual;
import model.StaffType;
import model.transactions.Request;
import model.transactions.Response;

public class Staff<T extends StaffType> implements Individual, Resource {
    private final Integer id;
    private T type;
    private Department department;

    public Staff(Integer id) {
        this.id = id;
    }

    public Integer getIdentifier() {
        return null;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

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
