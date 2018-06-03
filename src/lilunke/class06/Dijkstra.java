package lilunke.class06;

import java.util.*;

public class Dijkstra {
    class pair {
        int node;
        int len;
        public pair(int node, int len) {
            this.node = node;
            this.len = len;
        }
    }

    public List<pair> findShortestPath(int[][] graph, int startNode) {
        int N = graph.length;
        List<pair> res = new ArrayList<>();
        Set<Integer> map = new HashSet<>();
        PriorityQueue<pair> minHeap = new PriorityQueue<>(11, new Comparator<pair>(){
            public int compare(pair p1, pair p2) {
                if (p1.len < p2.len) {
                    return -1;
                } else if (p1.len == p2.len) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        minHeap.add(new pair(startNode, 0));
        while(!minHeap.isEmpty()) {
            pair temp = minHeap.poll();
            if (!map.contains(temp.node)) {
                map.add(temp.node);
                res.add(temp);
            }
            for (int i = 1; i < N; i++) {
                if (graph[temp.node][i] != 0 && !map.contains(i)) {
                    minHeap.add(new pair(i, temp.len + graph[temp.node][i]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0}
        };
        Dijkstra here = new Dijkstra();
        List<pair> res = here.findShortestPath(graph, 4);
        for (pair n : res) {
            System.out.println("<" + n.node + ", " + n.len + ">");
        }
    }
}
