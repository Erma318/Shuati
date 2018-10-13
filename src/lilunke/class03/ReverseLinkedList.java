package lilunke.class03;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList here = new ReverseLinkedList();
        ListNode one = here.new ListNode(1);
        ListNode two = here.new ListNode(2);
        ListNode three = here.new ListNode(3);
        ListNode four = here.new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        ListNode head = one;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        head = here.reverse(one);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
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

    public ListNode reverse(ListNode head) {
        // write your removeCho2 here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode curNode = head;

        while (curNode != null) {
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        return prev;
    }

    // recursive version
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
