package Leetcode;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

