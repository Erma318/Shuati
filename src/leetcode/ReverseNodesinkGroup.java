package leetcode;


public class ReverseNodesinkGroup {


     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode prev = p.next;
            ListNode cur = prev.next;
            int i = 1;
            while (cur != null && i < k) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                i++;
            }
            if (i == k) {
                ListNode next = p.next;
                p.next.next = cur;
                p.next  = prev;
                p = next;
            } else {
                cur = prev.next;
                prev.next = null;
                p.next.next = p;
                while (cur != p) {
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
         ListNode one = new ListNode(1);
         ListNode two = new ListNode(2);
         ListNode three = new ListNode(3);
         ListNode four = new ListNode(4);
         ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
         one.next = two;
         two.next = three;
         three.next = four;
         four.next = five;
         five.next = six;
         six.next = seven;
         seven.next = eight;
         ReverseNodesinkGroup here = new ReverseNodesinkGroup();
         here.reverseKGroup(one, 3);
    }
}
