package LinkedList.test;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode f = head;
        ListNode l = head.next;
        ListNode next = l.next;
        l.next = f;
        f.next = next;
        ListNode newHead = l;
        ListNode cTail = f;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            l = l.next.next;
            ListNode n = f.next;
            f.next = l;
            l.next = n;
            cTail.next = f;
            cTail = l;
            ListNode tmp = f;
            f = l;
            l = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        SwapPairs swapPairs = new SwapPairs();
        swapPairs.swapPairs(n1);
        System.out.println();
    }
}
