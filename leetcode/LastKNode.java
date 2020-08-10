package leetcode;

public class LastKNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            if (k > 1) {
                k--;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        if (k > 1) {
            return null;
        }
        return slow;
    }
}
