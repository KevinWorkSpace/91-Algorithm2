package Basic.LinkedList.lecture;

import java.util.List;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return partition(head);
    }

    public ListNode partition(ListNode head) {
        if (head.next == null) return head;
        if (head.next.next == null) {
            if (head.val > head.next.val) {
                ListNode next = head.next;
                next.next = head;
                head.next = null;
                return next;
            }
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        ListNode newHead = slow;
        ListNode h1 = partition(newHead);
        pre.next = null;
        ListNode h2 = partition(head);
        return merge(h1, h2);
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode n1 = h1;
        ListNode n2 = h2;
        ListNode head = null;
        if (n1.val > n2.val) {
            head = n2;
            n2 = n2.next;
        }
        else {
            head = n1;
            n1 = n1.next;
        }
        ListNode node = head;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                node.next = n2;
                n2 = n2.next;
                node = node.next;
            }
            else {
                node.next = n1;
                n1 = n1.next;
                node = node.next;
            }
        }
        if (n1 != null) {
            node.next = n1;
        }
        else {
            node.next = n2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode nMin1 = new ListNode(-1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        nMin1.next = n5;
        n5.next = n3;
        n3.next = n4;
        n4.next = n0;
        SortList sortList = new SortList();
        ListNode res = sortList.sortList(nMin1);
    }
}
