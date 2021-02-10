package priorityqueue;

import java.util.PriorityQueue;

public class App {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m = 2;

        for (int i=10;i>0; --i) {
            pq.add(i + 1);
            if (pq.size() > m) {
                System.out.println("Polling: " + pq.poll());
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
