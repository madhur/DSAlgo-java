package meetingrooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                { 1, 2},
                { 2, 3},
                { 2, 4 },
                { 4, 5 },
                { 5, 6}
        };

        int[][] intervals2 = new int[][]{
                { 7, 10},
                { 2, 4},

        };

        System.out.println(minMeetingRooms(intervals2));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] itv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(itv[1]);
            } else {
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }

                heap.offer(itv[1]);
            }
        }

        return count;
    }

}
