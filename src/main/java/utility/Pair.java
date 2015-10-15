package utility;

public class Pair<T, V> {
    private T head;
    private V tail;

    public Pair() {
        this(null, null);
    }

    public Pair(final T head, final V tail) {
        this.head = head;
        this.tail = tail;
    }

    public void setContent(final T head, final V tail) {
        this.head = head;
        this.tail = tail;
    }

    public T getHead() {
        return head;
    }

    public void setHead(T head) {
        this.head = head;
    }

    public V getTail() {
        return tail;
    }

    public void setTail(V tail) {
        this.tail = tail;
    }
}
