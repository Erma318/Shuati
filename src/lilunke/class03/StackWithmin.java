package lilunke.class03;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithmin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public void Solution() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int element) {
        stack.offerFirst(element);
        // when value <= current min value in stack, need to push the value to minStack
        if (minStack.isEmpty() || element <= minStack.peekFirst()) {
            minStack.offerFirst(element);
        }
    }

    public Integer min() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peekFirst();
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        int result = stack.pollFirst();
        // when the poppd value is the same as top value of minStack, the value need to be popped from minStack as well.
        if (minStack.peekFirst().equals(result)) {
            minStack.pollFirst();
        }
        return result;
    }

    public Integer top() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peekFirst();
    }
}
