package Queue;

public class Node<T extends Comparable<T>> {

    public T getData() {
        return data;
    }


    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
