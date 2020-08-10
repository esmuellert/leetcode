package leetcode;

import org.junit.Test;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode ptr = head;
        ListNode start = head;
        ListNode prevEnd = head;
        int counter = k - 1;
        ListNode reversed = head;
        boolean firstReverse = true;
        while (ptr != null) {
            if (counter > 0) {
                ptr = ptr.next;
                counter--;
            } else {
                ListNode rest = ptr.next;
                ptr.next = null;
                if (firstReverse) {
                    ptr = reverseList(start);
                    reversed = ptr;
                    start.next = rest;
                    start = rest;
                    ptr = rest;
                    firstReverse = false;
                } else {
                    ptr = reverseList(start);
                    prevEnd.next = ptr;
                    start.next = rest;
                    prevEnd = start;
                    start = rest;
                    ptr = rest;
                }
                counter = k - 1;
            }
        }
        return reversed;
    }

    private ListNode reverseList(ListNode head) {
        if (head.next == null || head == null) {
            return head;
        }
        ListNode endOfReversed = head.next;
        ListNode reversed = reverseList(head.next);
        endOfReversed.next = head;
        head.next = null;
        return reversed;
    }

    @Test
    public void test() {
        ReverseKGroup rkg = new ReverseKGroup();
        ListNode head = ListNode.buildLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        rkg.reverseKGroup(head, 2);
    }
}
