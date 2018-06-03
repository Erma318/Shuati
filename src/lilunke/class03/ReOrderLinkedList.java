package lilunke.class03;

public class ReOrderLinkedList {
    public static void main(String[] args) {
        ReOrderLinkedList here = new ReOrderLinkedList();
        ListNode one = here.new ListNode(1);
        ListNode two = here.new ListNode(2);
        ListNode three = here.new ListNode(3);
        ListNode four = here.new ListNode(4);
        ListNode five = here.new ListNode(5);
        ListNode six = here.new ListNode(6);
        ListNode seven = here.new ListNode(7);
        ListNode eight = here.new ListNode(8);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = six;
//        six.next = seven;
//        seven.next = eight;

        ListNode node  = here.reorder(one);
        while (node != null) {
            System.out.print(node.value + ", ");
            node = node.next;
        }


    }

    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // Write your solution here.
        ListNode two = findMid(head);
        two = reverse(two);
        //return two;
        return merge(head, two);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode two = slow.next;
        slow.next = null;
        return two;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode newHead = one;
        ListNode oneP = one.next;
        ListNode twoP = two;
        ListNode cur = newHead;
        while (oneP != null) {
            cur.next = twoP;
            cur = twoP;
            twoP = twoP.next;
            cur.next = oneP;
            cur = oneP;
            oneP = oneP.next;
        }
        if (twoP != null) {
            cur.next = twoP;
        }
        return newHead;
    }
}
