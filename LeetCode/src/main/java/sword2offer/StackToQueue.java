package sword2offer;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);
    }

    public int pop() {
/**
 * 应该先检查栈1是否为空
 */
        if (!stack1.isEmpty()) {
            Integer pop = stack1.pop();
            System.out.println(pop);
            return pop;
        }
        if (!stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            Integer pop = stack1.pop();
            System.out.println(pop);
            return pop;
        }
/**
 * 异常处理等学习异常机制后再来修改
 */
        return -1;
    }


    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        /*stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        stackToQueue.pop();
        stackToQueue.pop();*/
        stackToQueue.pop();
      /*  Stack stack = new Stack();
        stack.pop();*/
    }
}

