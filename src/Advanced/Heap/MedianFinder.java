package Advanced.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int count;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        count ++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (count % 2 == 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        else return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
