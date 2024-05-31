import java.util.Scanner;

class Main {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head1 = null;
    static Node tail1 = null;
    static Node head2 = null;
    static Node tail2 = null;

    public static void createList1(int ele) {
        Node newnode = new Node(ele);
        if (head1 == null) {
            head1 = newnode;
            tail1 = newnode;
        } else {
            tail1.next = newnode;
            tail1 = newnode;
        }
    }

    public static void createList2(int ele) {
        Node newnode = new Node(ele);
        if (head2 == null) {
            head2 = newnode;
            tail2 = newnode;
        } else {
            tail2.next = newnode;
            tail2 = newnode;
        }
    }

    public static Node mergeLists(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println("->NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for the first linked list
        int size1 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            createList1(sc.nextInt());
        }

        // Input for the second linked list
        int size2 = sc.nextInt();
        for (int i = 0; i < size2; i++) {
            createList2(sc.nextInt());
        }

        // Merging the two lists
        Node mergedHead = mergeLists(head1, head2);
        print(mergedHead);
    }
}
