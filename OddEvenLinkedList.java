import java.util.*;

class Main {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    static Node tail = null;

    public static void create(int ele) {
        Node newnode = new Node();
        newnode.data = ele;
        newnode.next = null;
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }

    public static void oddeven() {
        if (head == null) {
            return;
        }
        Node odd = head;
        Node even = head.next;
        Node evenStart = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenStart;
    }

    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            create(val);
        }
        oddeven();
        print();
    }
}
