package StackArray;

public class App {

    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>();

        myStack.push(10);
        myStack.push(100);
        myStack.push(1000);
        myStack.push(5);
        myStack.push(2);


        System.out.println("Min is: "+ myStack.min());

        myStack.pop();

        System.out.println("Min is: "+ myStack.min());

    }
}
