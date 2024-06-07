import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();   
    public static void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }  
    public static int pop() {
      if (queue1.isEmpty())
        return -1;
        return queue1.poll();
    }    
    public static int top() {
       if (queue1.isEmpty())
        return -1;
        return queue1.peek();
    }    
    public static boolean empty() {
        return queue1.isEmpty();
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        while (val != -1) {
            if (val == 1) {
                int n = sc.nextInt();
                push(n);
            } else if (val == 2) {
                System.out.println("Pop: " + pop());
            } else if (val == 3) {
                System.out.println("Top element: " + top());
            } else if (val == 4) {
                System.out.println("Is empty: " + empty());
            }
            val = sc.nextInt();
        }
        sc.close();
    }
}
