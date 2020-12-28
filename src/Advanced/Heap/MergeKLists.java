package Advanced.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i=0; i<lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                pq.add(head);
                head = head.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (!pq.isEmpty()) {
            tmp.next = pq.poll();
            tmp = tmp.next;
        }
        tmp.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[2];
        ListNode n1 = new ListNode(-2);
        ListNode n2 = new ListNode(-1);
        ListNode n3 = new ListNode(-1);
        ListNode n4 = new ListNode(-1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        lists[0] = n1;
        lists[1] = null;
        MergeKLists kLists = new MergeKLists();
        ListNode n = kLists.mergeKLists(lists);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}