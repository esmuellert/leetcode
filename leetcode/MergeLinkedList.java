package leetcode;

public class MergeLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        mergeHelper(sentinel, l1, l2);
        ListNode res = sentinel.next;
        sentinel.next = null;
        return res;
    }

    private void mergeHelper(ListNode endOfSentinel, ListNode l1, ListNode l2) {
        if (l1 == null) {
            endOfSentinel.next = l2;
            return;
        }
        if (l2 == null) {
            endOfSentinel.next = l1;
            return;
        }
        if (l1.val <= l2.val) {
            endOfSentinel.next = l1;
            ListNode ptr = l1.next;
            l1.next = null;
            endOfSentinel = l1;
            mergeHelper(endOfSentinel, ptr, l2);
        } else {
            endOfSentinel.next = l2;
            ListNode ptr = l2.next;
            l2.next = null;
            endOfSentinel = l2;
            mergeHelper(endOfSentinel, l1, ptr);
        }
    }
}
