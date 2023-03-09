package DSA.datastructures.queue;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {return stack1ToStack2(true);}

    public int peek() {
        return stack1ToStack2(false);
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int stack1ToStack2(boolean pop) {
        if (isEmpty())
            throw new IllegalStateException();

        if (!stack2.isEmpty())
            return stack2.pop();
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());

        if (pop) return stack2.pop();
        return stack2.peek();
    }
}