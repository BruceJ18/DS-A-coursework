package datastructures.stack;

public class MinStack {
    Stack stack = new Stack();
    Stack minStack = new Stack();

    public void push(int item) {
        stack.push(item);

        if (minStack.isEmpty())
            minStack.push(item);
        else if (item < minStack.peek())
            minStack.push(item);
    }

    public int pop() {
        if (stack.isEmpty())
            throw new IllegalArgumentException();

        var top = stack.pop();

        if (minStack.peek() == top)
            minStack.pop();

        return top;

    }

    public int min() {
        return minStack.peek();
    }
}
