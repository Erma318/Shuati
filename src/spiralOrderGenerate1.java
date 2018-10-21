import java.util.*;

public class spiralOrderGenerate1 {

    static class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }
    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here.
        Map<GraphNode,GraphNode> map = new HashMap<>();
        Deque<GraphNode> queue = new LinkedList<>();
        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node,new GraphNode(node.key));
                queue.offerFirst(node);
                bfs(map,queue);
            }
        }
        return new ArrayList<GraphNode>(map.values());
    }
    private void bfs (Map<GraphNode,GraphNode> map, Deque<GraphNode> queue) {
        while (!queue.isEmpty()) {
            GraphNode cur = queue.pollLast();
            GraphNode copy = cur;
            for (GraphNode nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    queue.offerFirst(nei);
                }
                copy.neighbors.add(map.get(nei));
            }
        }
    }

    public static void main (String[] arg){
        spiralOrderGenerate1 machine = new spiralOrderGenerate1();
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        one.neighbors.add(two);
        one.neighbors.add(three);
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors.add(one);
        three.neighbors.add(two);
        List<GraphNode> input = new LinkedList<>();
        input.add(one);
        input.add(two);
        input.add(three);
        System.out.println(machine.copy(input));
    }
}