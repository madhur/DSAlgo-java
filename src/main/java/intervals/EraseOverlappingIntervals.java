package intervals;

import java.time.chrono.Era;
import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = intervals[0][1];
        int count = 1;

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                // interval is not overlapping
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        EraseOverlappingIntervals eraseOverlappingIntervals = new EraseOverlappingIntervals();
        eraseOverlappingIntervals.eraseOverlapIntervals(new int[][]{{1,100}, {11, 22}, {1, 11}, {2,12}});

    }
}
