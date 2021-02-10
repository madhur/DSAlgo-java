package intervals;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});


        PriorityQueue<Character> pq = new PriorityQueue<Character>((o1, o2) -> {
            if(o1==o2) {
                return 0;
            }
            return 1;
        });
        pq.add('a');
        pq.add('a');
        pq.add('a');
        pq.add('b');
        pq.add('b');
        pq.add('b');
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
