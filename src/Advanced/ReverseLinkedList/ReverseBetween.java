package Advanced.ReverseLinkedList;

public class ReverseBetween {

    private ListNode successor;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null || head == null) return head;
        if (m == 1) {
            ListNode res = reverseN(head, n);
           return res;
        }
        int cnt = 1;
        ListNode node = head;
        ListNode pre = null;
        while (cnt < m) {
            pre = node;
            node = node.next;
            cnt ++;
        }
        ListNode next = null;
        ListNode left = pre;
        ListNode right = node;
        while (cnt <= n) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
            cnt ++;
        }
        left.next = pre;
        right.next = node;
        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        else {
            ListNode node = reverseN(head.next, n-1);
            head.next.next = head;
            head.next = successor;
            return node;
        }
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
        ReverseBetween between = new ReverseBetween();
        ListNode res = between.reverseBetween(n1, 2, 4);
    }
}
