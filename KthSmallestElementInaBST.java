import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Main {

    static TreeNode root;

    public static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        
        return node;
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        int[] result = {-1};
      
        kthSmallestUtil(root, k, count, result);

        return result[0];
    }

    public static void kthSmallestUtil(TreeNode root, int k, int[] count, int[] result) {
        if (root == null) {
            return;
        }
        
        kthSmallestUtil(root.left, k, count, result);
        
        count[0]++;
        if (count[0] == k) {
            result[0] = root.val;
            return;
        }
        
        kthSmallestUtil(root.right, k, count, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val;
        while ((val = scanner.nextInt()) != -1) {
            root = insert(root, val);
        }

        System.out.println("Enter the kth value:");
        int k = scanner.nextInt();

        int kthSmallestValue = kthSmallest(root, k);
        System.out.println("Smallest kth value " + kthSmallestValue);

        scanner.close();
    }
}
