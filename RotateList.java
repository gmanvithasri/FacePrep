import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        class Node {
            int data;
            Node prev;
            Node next;

            public Node(int data) {
                this.prev = null;
                this.data = data;
                this.next = null;
            }
        }

        class LinkedList {
            Node head;
            Node tail;

            public LinkedList() {
                this.head = null;
                this.tail = null;
            }

            public void insert(int data) {
                Node newNode = new Node(data);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    Node curr = head;
                    while (curr.next != null) {
                        curr = curr.next;
                    }
                    curr.next = newNode;
                    newNode.prev = curr;
                    tail = newNode;
                }
            }

            public void rotate(int k) {
                while (k > 0) {
                    head.prev = tail;
                    tail.next = head;
                    head = head.next;
                    head.prev = null;
                    tail = tail.next;
                    tail.next = null;
                    k--;
                }
            }
        }

        LinkedList List = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != -1) {
            List.insert(n);
            n = sc.nextInt();
        }
        n = sc.nextInt();
        int k = n;
        Node curr = List.head;
        System.out.println("Given linked list:");
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
        List.rotate(k);
        System.out.println("Rotated Linked list:");
        Node temp = List.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
