package lilunke.class05;

import java.util.*;

public class Bipartite {

    public boolean isBipartite(List<GraphNode> graph) {
        // write your removeCho2 here
        // 1 : Group 1, 2 : Group 2
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        Queue<GraphNode> NodeQueue = new LinkedList<>();
        NodeQueue.offer(graph.get(0));
        visited.put(graph.get(0), 1);
        while(!NodeQueue.isEmpty()) {
            GraphNode temp = NodeQueue.poll();
            for( GraphNode n : temp.neighbors) {
                if (visited.containsKey(n)&& visited.get(n) == visited.get(temp)) {
                    return false;
                }
                if (!visited.containsKey(n)) {
                    visited.put(n, 3 - visited.get(temp));
                    NodeQueue.offer(n);
                }
            }
        }
        return true;
    }

    public static class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }

    public static void main(String[] args) {
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        one.neighbors = Arrays.asList(two);
        two.neighbors = Arrays.asList(three);
        three.neighbors = Arrays.asList(four);
        List<GraphNode> graph = Arrays.asList(one, two, three, four);
        Bipartite here = new Bipartite();
        System.out.println(here.isBipartite(graph));
    }
}
