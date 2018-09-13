public class linkedlist {

     static public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {
            ListNode prev = p.next;
            ListNode cur = prev.next;
            int i = 1;
            for (; i < k; i++) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                if (cur == null) {
                    i++;
                    break;
                }
            }
            if (i == k) {
                ListNode next = p.next;
                p.next = prev;
                next.next = cur;
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
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c  = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = g;
//        g.next = h;
        linkedlist here = new linkedlist();
        ListNode start = here.reverseKGroup(a, 2);
        while (start != null) {
            System.out.println(start.val);
            start = start.next;
        }
    }

}
