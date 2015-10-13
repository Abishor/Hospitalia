package model;

public enum Visibility {
    PRIVATE("Private"),
    PUBLIC("Public"),
    ON_DEMAND("On_demand");

    private final String name;

    Visibility(final String name) {
        this.name = name;
    }
}
