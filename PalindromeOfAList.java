import java.util.*;

class Main {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to check if the linked list is a palindrome
    public static String isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return "true"; // Empty list or single node list is considered palindrome
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;

        // Compare the first half with the reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return "false";
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return "true";
    }

    // Function to reverse a linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String result = isPalindrome(head);
        System.out.println(Character.toUpperCase(result.charAt(0)) + result.substring(1));
    }
}
