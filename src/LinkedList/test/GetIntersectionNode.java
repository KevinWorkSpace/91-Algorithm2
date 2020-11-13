package Leetcode;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        if (headA == null || headB == null) return null;
        int cntA = 0;
        int cntB = 0;
        while (a != b) {
            a = a.next;
            b = b.next;
            if (a == null) {
                cntA ++;
                if (cntA == 2) return null;
                a = headB;
            }
            if (b == null) {
                cntB ++;
                if (cntB == 2) return null;
                b = headA;
            }
        }
        return a;
    }

}
