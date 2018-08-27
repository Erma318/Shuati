package lilunke.class03;

public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) return head;
        ListNode mid = midPoint(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        return merge(head, tail);
    }

    private ListNode midPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (two != null) {
            head.next = one;
            head = one;
            one = one.next;
            head.next = two;
            head = two;
            two = two.next;
        }
        if (one != null) {
            head.next = one;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ReOrderLinkedList here = new ReOrderLinkedList();
        one.next = two;
        two.next = three;
        three.next = four;
        here.reorder(one);
        while (one != null) {
            System.out.println(one.value);
            one = one.next;
        }
    }

//    public static void main(String[] args) {
//        ReOrderLinkedList here = new ReOrderLinkedList();
//        ListNode one = here.new ListNode(1);
//        ListNode two = here.new ListNode(2);
//        ListNode three = here.new ListNode(3);
//        ListNode four = here.new ListNode(4);
//        ListNode five = here.new ListNode(5);
//        ListNode six = here.new ListNode(6);
//        ListNode seven = here.new ListNode(7);
//        ListNode eight = here.new ListNode(8);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = six;
//        six.next = seven;
//        seven.next = eight;
//
//        ListNode node  = here.reorder(one);
//        while (node != null) {
//            System.out.print(node.value + ", ");
//            node = node.next;
//        }
//
//
//    }
//
    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
//
////    public ListNode reorder(ListNode head) {
////        // Write your solution here
////        ListNode mid = midPoint(head);
////        ListNode tail = reverse(mid.next);
////        ListNode node  = head;
////        mid.next = null;
////        while (node != null) {
////            System.out.print(node.value + ", ");
////            node = node.next;
////        }
////        System.out.println();
////        ListNode node0  = tail;
////        while (node0 != null) {
////            System.out.print(node0.value + ", ");
////            node0 = node0.next;
////        }
////        System.out.println();
////        System.out.println(tail.value);
////        System.out.println(mid.value);
////        System.out.println(head.value);
////        mid.next = null;
////        return merge(head,tail);
////    }
////
////    private ListNode midPoint(ListNode head){
////        ListNode slow = head;
////        ListNode quick = head;
////
////        while(quick.next != null && quick.next.next != null){
////            slow = slow.next;
////            quick = quick.next.next;
////        }
////        return slow;
////
////    }
////
////    private ListNode reverse(ListNode cur){
////        ListNode pre = null;
////        while(cur != null){
////            ListNode next = cur.next;
////            cur.next = pre;
////            pre = cur;
////            cur = next;
////        }
////        return pre;
////    }
////
////    private ListNode merge(ListNode head, ListNode tail){
////        ListNode dummy = new ListNode(0);
////        ListNode cur = dummy;
////
////        while(head != null && tail != null){
////            cur.next = head;
////            head = head.next;
////            cur.next.next = tail;
////            tail = tail.next;
////            cur = cur.next.next;
////        }
////        if(head != null){
////            cur.next = head;
////        }
////        return dummy.next;
////    }
//
//
//
//    public ListNode reorder(ListNode head) {
//        if (head == null || head.next == null || head.next.next == null) {
//            return head;
//        }
//        // Write your solution here.
//        ListNode two = findMid(head);
//        two = reverse(two);
//        //return two;
//        return merge(head, two);
//    }
//
//    private ListNode findMid(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode two = slow.next;
//        slow.next = null;
//        return two;
//    }
//
//    private ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        ListNode next = null;
//        ListNode cur = head;
//        while (cur != null) {
//            next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }
//
//    private ListNode merge(ListNode one, ListNode two) {
//        ListNode newHead = one;
//        ListNode oneP = one.next;
//        ListNode twoP = two;
//        ListNode cur = newHead;
//        while (oneP != null) {
//            cur.next = twoP;
//            cur = twoP;
//            twoP = twoP.next;
//            cur.next = oneP;
//            cur = oneP;
//            oneP = oneP.next;
//        }
//        if (twoP != null) {
//            cur.next = twoP;
//        }
//        return newHead;
//    }
}
