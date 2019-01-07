package past.bloomberg;

import java.util.*;

/*
bb开会有纽约，三番两个场所，必须接纳相同数量的来宾；每个来宾都分别记录了去纽约和三番的费用。让找一个分配方案使得总费用最小。
 */
public class chooseDestinationMakeSumMin {
    static class Node {
        int id;
        int p;
        public Node(int id, int p) {
            this.id = id;
            this.p = p;
        }
    }
    public static List<List<Integer>> findSumMin(int[] a, int[] b) {
        Node[] d = new Node[a.length];
        for (int i = 0; i < a.length; i++) {
            d[i] = new Node(i, Math.abs(a[i] - b[i]));
        }
        Comparator<Node> c = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.p > o2.p) {
                    return -1;
                } else if (o1.p == o2.p){
                    return 0;
                } else {
                    return 1;
                }
            }
        };
        Arrays.sort(d,c);
        int full = a.length / 2;
        List<Integer> aa = new LinkedList<>();
        List<Integer> bb = new LinkedList<>();
        for (Node n : d) {
            if (aa.size() < full && bb.size() < full) {
                if (a[n.id] < b[n.id]) {
                    aa.add(n.id);
                } else {
                    bb.add(n.id);
                }
            } else {
                if (aa.size() == full) {
                    bb.add(n.id);
                } else {
                    aa.add(n.id);
                }
            }

        }
        List<List<Integer>> res = new LinkedList<>();
        res.add(aa);
        res.add(bb);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 20, 11};
        int[] b = {6, 8, 10, 14};
        System.out.println(findSumMin(a, b));
    }
}
