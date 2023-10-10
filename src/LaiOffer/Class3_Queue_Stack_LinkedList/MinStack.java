package LaiOffer.Class3_Queue_Stack_LinkedList;

import java.util.Stack;

/**
 * Question 2: How to implement the min() function when using stack with time complexity O(1)
 */
public class MinStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MinStack() {
    }

    public void push(int input) {
        stack1.push(input);
        if (stack2.isEmpty()) {
            stack2.push(input);
        } else {
            if (stack2.peek() < input) {
                stack2.push(stack2.peek());
            } else {
                stack2.push(input);
            }
        }
    }

    public void pop() {
        System.out.println(stack1.pop());
        stack2.pop();
    }

    public void min() {
        if (stack1.isEmpty()) {
            System.out.println("The min stack is empty!");
            return;
        }

        System.out.println(stack2.peek());
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(1);
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.push(3);
        minStack.push(4);
        minStack.push(4);
        minStack.min();
        minStack.pop();
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.min();
    }

}
