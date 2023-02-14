package structure.tree;

public class CustomNode<T> {
    private T data;
    private CustomNode<T> left;
    private CustomNode<T> right;

    public CustomNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CustomNode<T> getLeft() {
        return left;
    }

    public void setLeft(CustomNode<T> left) {
        this.left = left;
    }

    public CustomNode<T> getRight() {
        return right;
    }

    public void setRight(CustomNode<T> right) {
        this.right = right;
    }
}
