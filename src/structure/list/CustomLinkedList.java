package structure.list;

public class CustomLinkedList<T> implements CustomList<T> {
    private CustomNode<T> head;
    private CustomNode<T> cur;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.cur = null;
        this.size = 0;
    }

    @Override
    public void add(T data) {
        CustomNode<T> newCustomNode = new CustomNode<>(data);
        if (size == 0) {
            head = newCustomNode;
            cur = newCustomNode;
            size++;
            return;
        }
        cur.setNext(newCustomNode);
        cur = cur.getNext();
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        CustomNode<T> temp = head;
        while (temp != null) {
            sb.append(temp.getValue());
            if (temp.getNext() != null) {
                sb.append(" ");
            }
            temp = temp.getNext();
        }

        return sb.toString();
    }
}
