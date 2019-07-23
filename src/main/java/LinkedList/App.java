package LinkedList;

public class App {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<Integer>();

        list.insert(10);
        list.insert(-2);
        list.insert(3);
        list.insert(100);
        list.insert(3);
        list.insert(-2);
        list.insert(-2);



        list.traverseList();

        list.removeDuplicates();
        System.out.println("");
        list.traverseList();

        callmethod(list.getRoot());
        System.out.println("Calling third");
        System.out.println(list.getRoot());
        list.traverseList();

    }

    private static void callmethod(Node<Integer> head) {

       head.setData(5);
//        while (head != null) {
//            head = head.getNextNode();
//        }
    }
}
