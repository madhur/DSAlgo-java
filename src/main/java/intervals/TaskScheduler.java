package intervals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        char[] letters = new char[26];
        final Map<Character, Integer> taskCount = new HashMap<>();
        for(int i=0;i<tasks.length; ++i) {
            Integer count = taskCount.get(tasks[i]);
            if (count == null) {
                taskCount.put(tasks[i], 1);
            }
            else {
                taskCount.put(tasks[i], count + 1);
            }

        }

        int count = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> {
            Integer count1 = taskCount.get(o1.c);
            Integer count2 = taskCount.get(o2.c);
            int size = taskCount.size();
            if (count1==null) {
                count1 = 0;
            }
            if (count2==null) {
                count2 = 0;
            }
            return Integer.compare(size - count2, size - count1);
        });

        for(char c : taskCount.keySet()) {
            pq.add(new Node(c, 1));
        }

        int cycle = 0;
        while(!pq.isEmpty()) {

            Node node = pq.poll();
            char c = node.c;
            cycle = cycle + node.count;
            System.out.println("Consuming node: " + c);
            if (!taskCount.containsKey(c)) {
                continue;
            }
            taskCount.put(c, taskCount.get(c) - 1);
            if (taskCount.get(c)==0) {
                taskCount.remove(c);
                continue;
            }
            else {
                pq.add(new Node(c, 1));
            }
        }
        System.out.println(cycle);
        return cycle;
    }

    public static void main(String[] args) {

        TaskScheduler taskScheduler = new TaskScheduler();
        taskScheduler.leastInterval(new char[]{'a','a','a','a','a','a','b','c','d','e','f','g'}, 2);
    }
    class Node  {
        char c;
        int count;
        public Node(char c, int count) {
            this.c = c;
            this.count  = count;
        }
    }
}
