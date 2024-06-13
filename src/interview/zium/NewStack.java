package interview.zium;

import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Stack
 *
 *            Implement PUSH, POP, TOP in O(1)
 *
 *            Implement getMin() in O(1)


 *    1 2 1
 */
public class NewStack<T> {

    private Node<T> top;
    private Node<T> min;
    private final Lock lock = new ReentrantLock();

    private static class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;

        Node(T val) {
            this.val = val;
        }
    }

    public void push(T newValue) {
        lock.lock();
        try {
            Node<T> newNode = new Node(newValue);
            Comparator<T> newComparator = new Comparator<T>() {
                @Override public int compare(T o1, T o2) {
                    return 0;
                }
            };
            newNode.next = top;
            if (top != null)
                top.prev = newNode;
            top = newNode;

            if (min == null || newComparator.compare(newValue, min.val) > 0)
                min = newNode;
        } finally {
            lock.unlock();
        }
    }

    public void pop() {
        lock.lock();
        try {
            if (top == null)
                return;

            if (top == min)
                min = min.next;

            top = top.next;
            if (top != null)
                top.prev = null;
        } finally {
            lock.unlock();
        }
    }

    public T top() {
        lock.lock();
        try {
            if (top != null)
                return top.val;
            else
                return null;
        } finally {
            lock.unlock();
        }
    }

    public T getMin() {
        lock.lock();
        try {
            if (min != null)
                return min.val;
            else
                return null;
        } finally {
            lock.unlock();
        }
    }
}
