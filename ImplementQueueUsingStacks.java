import java.util.*;

class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int element) {
        stack1.push(element);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1; // or throw an exception
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public void printQueueElements() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println("Queue elements are:");
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numElements = scanner.nextInt();
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        for (int i = 0; i < numElements; i++) {
            int element = scanner.nextInt();
            queue.enqueue(element);
        }

        int numDequeue = scanner.nextInt();
        for (int i = 0; i < numDequeue; i++) {
            queue.dequeue();
        }
        queue.printQueueElements();
        scanner.close();
    }
}
