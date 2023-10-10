package LaiOffer.Class3_Queue_Stack_LinkedList;

import java.util.Stack;

/**
 * Question 4: How to use multiple stacks to implement a de-queue (deque)
 * Preferably O(1) amortized time for all operations
 */
public class DequeByStacks {

    Stack<Integer> stackLeft = new Stack<>();
    Stack<Integer> stackRight = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int size = 0;

    public DequeByStacks() {

    }

    private void pullLeft() {
        balanceDeque(stackLeft, stackRight);
    }

    private void pullRight() {
        balanceDeque(stackRight, stackLeft);
    }

    private void balanceDeque(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (size == 0) {
            System.out.println("Deque is empty!");
        } else if (size == 1) {
            if (stack1.size() > 0) {
                System.out.println(stack1.pop());
            } else {
                System.out.println(stack2.pop());
            }
        }

        if (stack1.size() == 0) {
            for (int i = 0; i < size / 2; i++) {
                temp.push(stack2.pop());
            }

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            while (!temp.isEmpty()) {
                stack2.push(temp.pop());
            }
            System.out.println(stack1.pop());
        } else {
            System.out.println(stack1.pop());
        }
    }

    private void pushRight(int input) {
        stackRight.push(input);
        size++;
    }

    private void pushLeft(int input) {
        stackLeft.push(input);
        size++;
    }

    public static void main(String[] args) {
        DequeByStacks deque = new DequeByStacks();
        deque.pushLeft(3);
        deque.pushLeft(4);
        deque.pushRight(5);
        deque.pushLeft(6);
        deque.pullRight();
        deque.pullRight();
        deque.pullLeft();
    }

}
