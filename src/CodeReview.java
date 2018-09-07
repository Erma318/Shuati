import com.sun.org.apache.bcel.internal.classfile.Code;
import lilunke.class05.Bipartite;

import java.util.*;

public class CodeReview {

     static public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode headtwo = head.next;
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            int i = 0;
            for (; i < k; i++) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                if (i != k && cur == null) {
                    break;
                }
            }
            if (i == k) {
                head.next = prev;
                headtwo.next = cur;
                head = headtwo;
                headtwo = head.next;
            } else {
                cur = prev.next;
                while (cur != head) {
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
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        CodeReview here = new CodeReview();
        ListNode start = here.reverseKGroup(a, 3);
        while (start != null) {
            System.out.println(start.val);
            start = start.next;
        }
    }

}
