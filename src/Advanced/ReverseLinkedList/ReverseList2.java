package Advanced.ReverseLinkedList;

public class ReverseList2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return first;
    }
}
