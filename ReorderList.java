import java.util.*;

class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    // Method to insert a node at the beginning of the list
    public static void insert(int ele) {
        Node newnode = new Node(ele);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    // Method to reorder the list as per the given task
    public static Node reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // Find the middle of the list
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        Node prev = null;
        Node current = slow.next;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        slow.next = null;

        // Merge the two halves
        Node first = head;
        Node second = prev;
        while (second != null) {
            Node nextFirst = first.next;
            Node nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;
            first = nextFirst;
            second = nextSecond;
        }

        return head;
    }

    // Method to print the list
    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            insert(sc.nextInt());
        }
      
        head = reorderList(head);
        print(head);
    }
}
