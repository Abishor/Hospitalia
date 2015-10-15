package model;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

public class Person<T> {
    private final UUID id;

    private String name;
    private T information;

    public Person(final String name) {
        this(name, null);
    }

    public Person(final String name, final T information) {
        checkArgument(!name.isEmpty(), "A name must be specified");
        id = UUID.randomUUID();
        this.name = name;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public T getInformation() {
        return information;
    }

    public void setInformation(final T information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", information=" + information +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Person<?> person = (Person<?>) o;

        if (!id.equals(person.id)) return false;
        if (!name.equals(person.name)) return false;
        return !(information != null ? !information.equals(person.information) : person.information != null);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (information != null ? information.hashCode() : 0);
        return result;
    }
}
