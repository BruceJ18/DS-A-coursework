package datastructures.stack;

import java.util.Arrays;

public class TwoStacks {
    private int top2;
    private int top1;
    int[] items;

    public void twoStacks(int capacity) {
            if (capacity <= 0)
                throw new IllegalArgumentException("input must be greater than or equal to one.");

            items = new int[capacity];
            top1 = -1;
            top2 = capacity;
    }

    public void push1(int item) {
        if (isFull1())
            throw new IllegalStateException();

        items[++top1] = item;
    }

    public void push2(int item) {
        if (isFull2())
            throw new IllegalStateException();

        items[--top2] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return items[top1--];
    }

    public int pop2() {
        if (isEmpty1())
            throw new IllegalStateException();

        return items[top2++];
    }

    private boolean isEmpty1(){
        return top1 == -1;
    }

    private boolean isFull1(){
        return top1 + 1 == top2;
    }

    private boolean isEmpty2(){
        return top2 == items.length;
    }

    private boolean isFull2(){
        return top2 - 1 == top1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
