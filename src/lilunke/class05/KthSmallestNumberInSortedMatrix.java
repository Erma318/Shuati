package lilunke.class05;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    public static void main (String[] args) {
        KthSmallestNumberInSortedMatrix here = new KthSmallestNumberInSortedMatrix();
        int[][] matrix = {{1, 2, 3, 4, 5},{2, 3, 4, 5, 6},{3, 4, 5, 6, 7}};
        int k = 7;
        System.out.println(here.kthSmallest(matrix, k));
    }
    class Node{
        int value;
        int x;
        int y;
        boolean visited;
        public Node(int n, int i, int j) {
            value = n;
            x = i;
            y = j;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here.
        int rows = matrix.length;
        int columns = matrix[0].length;
        PriorityQueue<Node> minQueue = new PriorityQueue<Node>(k, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value? -1 : 1;
            }
        });
        //boolean[][]visited = new boolean[rows][columns];
        minQueue.offer(new Node(matrix[0][0], 0, 0));
        //visited[0][0] = true;
        int count = 0;
        while(count < k - 1) {
            Node temp = minQueue.poll();
            count++;
            if (temp.x + 1 < rows) {
                minQueue.offer(new Node(matrix[temp.x + 1][temp.y], temp.x + 1, temp.y));
            }
            if (temp.y + 1 < columns && temp.x == 0) {
                minQueue.offer(new Node(matrix[temp.x][temp.y + 1], temp.x, temp.y + 1));
            }
        }
//        while(count < k - 1 ) {
//            Node temp = minQueue.poll();
//            count++;
//            if (temp.x + 1 < rows && !visited[temp.x + 1][temp.y]) {
//                minQueue.offer(new Node(matrix[temp.x + 1][temp.y], temp.x + 1, temp.y));
//                visited[temp.x + 1][temp.y] = true;
//            }
//            if (temp.y + 1 < columns && !visited[temp.x][temp.y + 1]) {
//                minQueue.offer(new Node(matrix[temp.x][temp.y + 1], temp.x, temp.y + 1));
//                visited[temp.x][temp.y + 1] = true;
//            }
//        }
        return minQueue.peek().value;
    }
}
