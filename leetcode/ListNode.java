package leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildLinkedListFromArray(int[] nums) {
        ListNode sentinel = new ListNode(-1);
        ListNode ptr = sentinel;
        for (int i = 0; i < nums.length; i++) {
            ptr.next = new ListNode(nums[i]);
            ptr = ptr.next;
        }
        ListNode res = sentinel.next;
        sentinel.next = null;
        return res;
    }
}