package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;



public class mergeKLists {

     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }



    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val)
                    return -1;
                else if (n1.val == n2.val)
                    return 0;
                else
                    return 1;
            }
        });
        for (ListNode start : lists) {
            if (start != null)
                queue.add(start);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
         ListNode one = new ListNode(1);
         ListNode two = new ListNode(2);
         ListNode three = new ListNode(3);
         ListNode four = new ListNode(4);
         one.next = three;
         two.next = four;
         ListNode[] lists  = {one, three};
         mergeKLists here = new mergeKLists();
         here.mergeKLists(lists);
    }
}
