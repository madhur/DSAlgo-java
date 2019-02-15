package LinkedList;

public class Node<T extends Comparable<T>> {

    private T data;

    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
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
        return data.toString();
    }

    @Override
    public int hashCode() {
        Integer t = (Integer) data;
        return t;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return data==node.getData();
    }
}
