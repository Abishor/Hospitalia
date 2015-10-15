package processing;

import connection.OperationResult;

public interface Processor<T> {
    OperationResult process(final T input);
}
