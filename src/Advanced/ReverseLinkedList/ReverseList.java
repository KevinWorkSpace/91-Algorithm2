package Advanced.ReverseLinkedList;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
