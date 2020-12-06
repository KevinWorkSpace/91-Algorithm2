package Basic.LinkedList.test;

import java.util.HashMap;

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size ++;
            tmp = tmp.next;
        }
        int cnt = 0;
        while (head != null) {
             int num = (cnt + k) % size;
             map.put(num, head);
             head = head.next;
             cnt ++;
        }
        head = map.get(0);
        ListNode node = head;
        for (int i=1; i<size; i++) {
            node.next = map.get(i);
            node = node.next;
        }
        node.next = null;
        return head;
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
        RotateRight rotateRight = new RotateRight();
        rotateRight.rotateRight(n1, 2);
    }
}
