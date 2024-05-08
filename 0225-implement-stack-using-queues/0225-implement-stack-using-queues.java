import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        if (queue1.isEmpty()) {
            return -1; // Stack is empty
        }
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int poppedElement = queue1.poll();
        swapQueues();
        return poppedElement;
    }
    
    public int top() {
        if (queue1.isEmpty()) {
            return -1; // Stack is empty
        }
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.offer(queue1.poll());
        swapQueues();
        return topElement;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
    
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}
