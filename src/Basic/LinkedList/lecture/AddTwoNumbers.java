package Basic.LinkedList.lecture;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        int plus = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode node = head;
        while (l1 != null && l2 != null) {
            node.next = new ListNode((l1.val + l2.val + plus) % 10);
            plus = (l1.val + l2.val + plus) / 10;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = null;
        if (l1 != null) {
            remain = l1;
        }
        else {
            remain = l2;
        }
        while (remain != null) {
            node.next = new ListNode((remain.val + plus) % 10);
            plus = (remain.val + plus) / 10;
            node = node.next;
            remain = remain.next;
        }
        if (plus == 1) {
            node.next = new ListNode(1);
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
