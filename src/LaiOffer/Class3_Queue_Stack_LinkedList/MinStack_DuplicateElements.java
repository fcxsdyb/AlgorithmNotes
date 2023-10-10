package LaiOffer.Class3_Queue_Stack_LinkedList;

import java.util.Stack;

/**
 * Question 2 Follow Up:
 * How to optimize the space usage of stack2 assumptions there are a lot of duplicate elements in stack1?
 */
public class MinStack_DuplicateElements {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Pair> stack2 = new Stack<>();

    public MinStack_DuplicateElements() {
    }

    //Using number and stack1 size to record the min value "index" to avoid the space waste
    public void push(int input) {
        stack1.push(input);

        if (stack2.isEmpty() || input < stack2.peek().minValue) {
            stack2.push(new Pair(input, stack1.size()));
        }
    }

    public void pop() {
        if (stack1.size() == stack2.peek().stackSize) {
            stack2.pop();
        }

        System.out.println(stack1.pop());
    }

    public void min() {
        if (stack1.isEmpty()) {
            System.out.println("The min stack is empty!");
            return;
        }

        System.out.println(stack2.peek().minValue);
    }

    private class Pair {
        int minValue;
        int stackSize;

        public Pair(int minValue, int stackSize) {
            this.minValue = minValue;
            this.stackSize = stackSize;
        }
    }

    public static void main(String[] args) {
        MinStack_DuplicateElements minStack = new MinStack_DuplicateElements();
        minStack.push(1);
        minStack.pop();
        minStack.push(3);
        minStack.min();
        minStack.push(2);
        minStack.min();
        minStack.push(1);
        minStack.min();
        minStack.pop();
        minStack.push(3);
        minStack.push(4);
        minStack.push(4);
        minStack.min();
    }


}
