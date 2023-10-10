package LaiOffer.Class3_Queue_Stack_LinkedList;

import java.util.Stack;

/**
 * Question 1: How could we implement a queue by using two stacks?
 * <p>
 * Time Complexity:
 * push() --> O(1)
 * pop()
 * -->
 * Amortized time complexity O(1)
 * <p>
 * Explain:
 * 1st time call pop()  n (pop from Stack1) + n (push to Stack2) + 1 (pop from Stack1) = 2n + 1
 * 2nd time call pop() time = 1
 * 3rd time call pop() time = 1
 * nth time call pop() time = 1
 * Amortized time complexity = (2n + 1 + (n - 1) x 1) / n = 3n / n = 3 = O(1)
 */
public class QueueByTwoStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public QueueByTwoStacks() {

    }

    // Using stack1 to buffer all new elements
    public void push(int input) {
        stack1.push(input);
    }

    // Using Stack2 To pop out the 1st element
    //
    // Case2.1 If stack2 is empty, then we move all the element from stack1 to stack2 one by one.
    // Then pop the top element from Stack2.
    //
    // Case2.2 If stack2 is NOT empty, then we call stack2.pop()
    public void pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            System.out.println(stack2.pop());
        } else {
            System.out.println(stack2.pop());
        }
    }

    public static void main(String[] args) {
        QueueByTwoStacks queue = new QueueByTwoStacks();
        queue.push(3);
        queue.push(5);
        queue.pop();
        queue.push(7);
        queue.pop();
        queue.pop();
        queue.push(6);
        queue.pop();
        queue.pop();
    }

}
