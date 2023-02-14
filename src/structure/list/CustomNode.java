package structure.list;

public class CustomNode<T> {
    private T value;
    private CustomNode<T> next;

    public CustomNode(T value) {
        this.value = value;
        this.next = null;
    }

    public CustomNode(T value, CustomNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public CustomNode<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(CustomNode<T> next) {
        this.next = next;
    }
}
