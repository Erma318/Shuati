package lilunke.class23;

public class findLargestSmall {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public int find(Node root, int target) {
        int res = -1;
        int min_diff = Integer.MAX_VALUE;
        Node cur = root;
        while (cur != null) {
            if (cur.value >= target) {
                cur = cur.left;
            } else {
                if ((target - cur.value) < min_diff) {
                    min_diff = target - cur.value;
                    res = cur.value;
                }
                cur = cur.right;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Node ten = new Node(10);
        Node five = new Node(5);
        Node two = new Node(2);
        Node fifteen = new Node(15);
        Node twelve = new Node(12);
        Node twenty = new Node(20);
        ten.left = five; ten.right = fifteen;
        five.left = two;
        //fifteen.left = twelve;
        fifteen.right = twenty;
        findLargestSmall here = new findLargestSmall();
        System.out.println(here.find(ten, 14));
    }
}
