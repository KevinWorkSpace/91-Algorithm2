package Advanced.Design;

public class MyCircularDeque {

    private ListNode head = new ListNode(-1);
    private ListNode tail = new ListNode(-1);
    private int size;
    private int cnt;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head.next = tail;
        tail.pre = head;
        size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (cnt == size) return false;
        ListNode next = head.next;
        ListNode node = new ListNode(value);
        node.next = next;
        next.pre = node;
        head.next = node;
        node.pre = head;
        cnt ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (cnt == size) return false;
        ListNode pre = tail.pre;
        ListNode node = new ListNode(value);
        node.pre = pre;
        pre.next = node;
        node.next = tail;
        tail.pre = node;
        cnt ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (cnt == 0) return false;
        ListNode next = head.next.next;
        head.next = next;
        next.pre = head;
        cnt --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (cnt == 0) return false;
        ListNode pre = tail.pre.pre;
        tail.pre = pre;
        pre.next = tail;
        cnt --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (cnt == 0) return -1;
        return head.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (cnt == 0) return -1;
        return tail.pre.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cnt == size;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode pre;

    public ListNode(int val) {
        this.val = val;
    }
}
