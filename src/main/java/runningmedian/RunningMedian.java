package runningmedian;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class RunningMedian {

    public static double[] getMedians(int[] array) {
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });

        PriorityQueue<Integer> highers = new PriorityQueue<>();

        double [] medians = new double[array.length];
        for (int i=0; i<array.length; i++) {
            int number = array[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers: highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        }
        else {
            return biggerHeap.peek();
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size()? lowers: highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size()? highers: lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() ==0 || number < lowers.peek()) {
            lowers.add(number);
        }
        else {
            highers.add(number);
        }

    }

    public static void main(String[] args) {

        double[] medians = getMedians(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println(Arrays.toString(medians));

    }
}