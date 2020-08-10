package leetcode;

public class ReverseList {
    //Berkeley CS 61B recursion
    // public leetcode.ListNode leetcode.reverseList(leetcode.ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //     leetcode.ListNode endOfReversed = head.next;
    //     leetcode.ListNode reversed = leetcode.reverseList(head.next);
    //     endOfReversed.next = head;
    //     head.next = null;
    //     return reversed;
    // }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = head.next;
        head.next = null;

        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = head;
            head = ptr;
            ptr = next;
        }
        return head;
    }

/*    public leetcode.ListNode leetcode.reverseList(leetcode.ListNode head) {
        leetcode.ListNode prev = head;
        leetcode.ListNode curr = head.next;
        leetcode.ListNode next = head.next.next;
        prev.next = null;
        head = reverseLinkedList(prev, curr, next);
        return head;
    }

    private leetcode.ListNode reverseLinkedList(leetcode.ListNode prev, leetcode.ListNode curr, leetcode.ListNode next) {
        if (next == null) {
            curr.next = prev;
            return curr;
        } else {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
            return reverseLinkedList(prev, curr, next);
        }
    }

    public static void main(String[] args) {
        leetcode.ListNode head = new leetcode.ListNode(5);
        leetcode.ListNode curr = head;
        for (int i = 0; i < 10; i++) {
            curr.next = new leetcode.ListNode(i);
            curr = curr.next;
        }
        curr.next = null;
        leetcode.reverseList r = new leetcode.reverseList();
        r.leetcode.reverseList(head);
    }*/
}
