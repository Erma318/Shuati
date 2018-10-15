package syntaxTest;

import java.util.PriorityQueue;

public class heapDuplicate {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(1);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
    //所以heap支持重复元素
}
