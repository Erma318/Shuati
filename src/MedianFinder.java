import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    // always keep minHeap.size() = maxHeap.size() or maxHeap.size() + 1
    public void addNum(int num) {
        if (minHeap.size() == 0) {
            minHeap.offer(num);
            return;
        }
        if (num < minHeap.peek()) {
            maxHeap.offer(num);
        } else {
            if (minHeap.size() == maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
            minHeap.offer(num);
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.poll() + (double) maxHeap.poll()) / 2;
        } else {
            return (double) minHeap.poll();
        }
    }
}
