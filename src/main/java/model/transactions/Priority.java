package model.transactions;

public enum Priority {
    HIGHEST("Mandatory"),
    HIGH("High"),
    REGULAR("Standard"),
    LOW("Low");

    String text;

    Priority(final String text) {
        this.text = text;
    }
}
