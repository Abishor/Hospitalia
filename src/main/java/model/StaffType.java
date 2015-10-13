package model;

public enum StaffType {
    Doctor("Doctor"),
    Nurse("Nurse"),
    Technician("Technician");

    private final String name;

    StaffType(final String name) {
        this.name = name;
    }
}
