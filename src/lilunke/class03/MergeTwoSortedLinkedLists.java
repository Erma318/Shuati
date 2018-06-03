package lilunke.class03;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        MergeTwoSortedLinkedLists here = new MergeTwoSortedLinkedLists();
        ListNode one = here.new ListNode(1);
        ListNode two = here.new ListNode(2);
        Integer x = 0;
        if(x != null) {

        }
//        ListNode three = here.new ListNode(3);
//        ListNode four = here.new ListNode(4);
//        ListNode five = here.new ListNode(5);
//        ListNode six = here.new ListNode(6);
//        ListNode seven = here.new ListNode(7);
//        ListNode eight = here.new ListNode(8);
//        one.next = three;
//        three.next = five;
//        five.next = seven;
//        two.next = four;
//        four.next = six;
//        six.next = eight;
        ListNode node  = here.merge(one, two);
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

    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(one != null && two != null) {
            if (one.value <= two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        // link the remaining possible nodes
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }


//    public ListNode merge(ListNode one, ListNode two) {
//        // write your solution here
//        ListNode newHead = null;
//        if (one == null && two == null) {
//            return null;
//        }
//        if (one == null) {
//            return two;
//        }
//        if (two == null) {
//            return one;
//        }
//        ListNode oneP = null;
//        ListNode twoP = null;
//        if (one.value < two.value) {
//            newHead = one;
//            oneP = one.next;
//            twoP = two;
//        } else {
//            newHead = two;
//            oneP = one;
//            twoP = two.next;
//        }
//        ListNode curNode = newHead;
//        while (oneP != null) {
//            if (twoP == null || oneP.value < twoP.value) {
//                curNode.next = oneP;
//                curNode = oneP;
//                oneP = oneP.next;
//            } else {
//                curNode.next = twoP;
//                curNode = twoP;
//                twoP = twoP.next;
//            }
//        }
//        while (twoP != null) {
//            curNode.next = twoP;
//            curNode = twoP;
//            twoP = twoP.next;
//        }
//
//        return newHead;
//    }
}
