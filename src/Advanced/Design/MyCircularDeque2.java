package Advanced.Design;

public class MyCircularDeque2 {

    int[] res;
    int capacity;
    int front = 0;
    int tail = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque2(int k) {
        capacity = k + 1;
        res = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        res[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        res[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return res[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return res[(tail - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % capacity == front;
    }
}
