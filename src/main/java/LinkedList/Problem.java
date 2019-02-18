package LinkedList;

public class Problem {

    Node<Integer> newNode;
    Node<Integer> tailNode;

    public Node union(Node<Integer> head1, Node<Integer> head2) {

        while (head1!= null && head2!= null) {

            if (head1.getData() <= head2.getData()) {
                tailNode = add(head1.getData());
            }
            else if (head1.getData() > head2.getData()) {
                tailNode = add(head2.getData());
            }
        }

        return newNode;
    }

    public Node<Integer> add(int data) {

        while(newNode != null && newNode.getNextNode() != null) {
            newNode = newNode.getNextNode();
        }

        if (newNode == null) {
            newNode = new Node<Integer>(data);
        }
        else {
            newNode.setNextNode(newNode);
        }

        return newNode;
    }
}
