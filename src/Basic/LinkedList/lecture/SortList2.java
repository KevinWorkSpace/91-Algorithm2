package Basic.LinkedList.lecture;

public class SortList2 {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return partition(head);
    }

    public ListNode partition(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        ListNode h1 = partition(slow);
        pre.next = null;
        ListNode h2 = partition(head);
        return merge(h1, h2);
    }

    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                node.next = n2;
                n2 = n2.next;
            }
            else {
                node.next = n1;
                n1 = n1.next;
            }
            node = node.next;
        }
        if (n1 != null) {
            node.next = n1;
        }
        else {
            node.next = n2;
        }
        return head.next;
    }
}
