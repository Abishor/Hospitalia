package model.transactions;

import org.apache.http.HttpStatus;

public class Response<T> {

    private final int status;
    private T content;

    public Response() {
        this(HttpStatus.SC_BAD_REQUEST, null);
    }

    public Response(final int status, final T content) {
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public T getContent() {
        return content;
    }

    public void setContent(final T content) {
        this.content = content;
    }
}
