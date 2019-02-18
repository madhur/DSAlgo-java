package LinkedList;

import javax.print.attribute.IntegerSyntax;

public class App1 {

    public static void main(String[] args) {

        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.insert(6);
        list1.insert(5);
        list1.insert(4);
        list1.insert(2);

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.insert(8);
        list2.insert(7);
        list2.insert(3);
        list2.insert(1);

        Node<Integer> node = new Problem().union(list1.getRoot(), list2.getRoot());
        Node<Integer> traverser =node;
        while(traverser != null) {
            System.out.println(traverser.getData());
            traverser = traverser.getNextNode();
        }

    }
}
