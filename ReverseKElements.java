import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev != null) {
            prev = reverseNextK(prev, k);
        }
        
        return dummy.next;
    }
    
    private static ListNode reverseNextK(ListNode prev, int k) {
        ListNode last = prev;
        // Check if there are at least k nodes left
        for (int i = 0; i < k && last != null; i++) {
            last = last.next;
        }
        
        // If less than k nodes left, no need to reverse
        if (last == null) return null;
        
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        
        for (int i = 1; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next;
        }
        
        return tail;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Read the linked list
        int x;
        while ((x = scanner.nextInt()) != -1) {
            current.next = new ListNode(x);
            current = current.next;
        }
        
        // Read the value of k
        int k = scanner.nextInt();
        
        // Reverse every k nodes
        ListNode reversedList = reverseKGroup(dummy.next, k);
        
        // Print the reversed list
        while (reversedList != null) {
            System.out.println(reversedList.val);
            reversedList = reversedList.next;
        }
        
        scanner.close();
    }
}
