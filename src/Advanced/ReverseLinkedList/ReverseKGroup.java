package Advanced.ReverseLinkedList;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        for (int i=0; i<k; i++) {
            if (node == null) return head;
            node = node.next;
        }
        ListNode newHead = reverseK(head, node);
        head.next = reverseKGroup(node, k);
        return newHead;
    }

    public ListNode reverseK(ListNode head, ListNode tail) {
        ListNode node = head;
        ListNode pre = null;
        while (node != tail) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        int k = 2;
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(n1, k);
    }
}
