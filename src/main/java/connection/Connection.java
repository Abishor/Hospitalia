package connection;

public interface Connection<T> {
    void connect();

    void disconnect();

    OperationResult save(final T object);
}
