package model.transactions;

import javax.annotation.Nullable;
import java.util.UUID;

public class Request<T> {
    private final UUID id;
    @Nullable
    private T data;
    private Priority priority;

    public Request() {
        id = UUID.randomUUID();
        data = null;
        priority = Priority.REGULAR;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(final Priority priority) {
        this.priority = priority;
    }
}
