package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Department {
    private final Integer id;
    private final String title;

    @JsonCreator
    public Department(@JsonProperty("id") final Integer id, @JsonProperty("title") final String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
