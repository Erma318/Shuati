package lilunke.class03;

public class PartitionLinkedList {
    public static void main(String[] args) {
        PartitionLinkedList here = new PartitionLinkedList();
        ListNode one = here.new ListNode(1);
        ListNode two = here.new ListNode(2);
        ListNode three = here.new ListNode(3);
        ListNode four = here.new ListNode(4);
        ListNode five = here.new ListNode(5);
        ListNode six = here.new ListNode(6);
        ListNode seven = here.new ListNode(7);
        ListNode eight = here.new ListNode(8);
        //five.next = one;
//        one.next = seven;
//        three.next = seven;
        seven.next = two;
//        two.next = six;

        ListNode node  = here.partition(seven, 5);
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

    public ListNode partition(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        // write your removeCho2 here
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode large = largeHead;
        ListNode cur = head;
        while(cur != null) {
            if (cur.value < target) {
                small.next = cur;
                small = small.next;
                cur = cur.next;
            } else {
                large.next = cur;
                large = large.next;
                cur = cur.next;
            }
        }
        small.next = largeHead.next;
        large.next = null;
        return smallHead.next;
    }
}
