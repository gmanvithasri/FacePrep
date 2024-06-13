import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    public static String isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "True" : "False";
    }

    public static boolean isBSTUtil(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isBSTUtil(node.left, min, node.val) && isBSTUtil(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of nodes
        int n = scanner.nextInt();
        int[] keys = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scanner.nextInt();
        }

        // Construct the binary tree
        TreeNode root = constructBinaryTree(keys);

        // Check if the tree is a BST
        String result = isBST(root);
        System.out.println(result);
    }

    public static TreeNode constructBinaryTree(int[] keys) {
        if (keys == null || keys.length == 0) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[keys.length];
        for (int i = 0; i < keys.length; i++) {
            nodes[i] = new TreeNode(keys[i]);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(nodes[0]);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode node = queue.poll();
            node.left = nodes[i++];
            queue.add(node.left);
            if (i < nodes.length) {
                node.right = nodes[i++];
                queue.add(node.right);
            }
        }

        return nodes[0];
    }
}
