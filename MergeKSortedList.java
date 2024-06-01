import java.util.PriorityQueue;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!pq.isEmpty()) {
            ListNode smallestNode = pq.poll();
            tail.next = smallestNode;
            tail = tail.next;
            
            if (smallestNode.next != null) {
                pq.offer(smallestNode.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of lists
        int k = scanner.nextInt();
        
        // Construct an array to hold the linked lists
        ListNode[] lists = new ListNode[k];
        
        // Read each list and construct linked lists
        for (int i = 0; i < k; i++) {
            lists[i] = constructLinkedList(scanner);
        }
        
        // Merge the lists
        Main solution = new Main();
        ListNode mergedList = solution.mergeKLists(lists);
        
        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        
        scanner.close();
    }
    
    // Utility function to construct a linked list from input
    private static ListNode constructLinkedList(Scanner scanner) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int val;
        while ((val = scanner.nextInt()) != -1) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
}
