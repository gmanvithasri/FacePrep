import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String treeInput = scanner.nextLine();
        TreeNode root = buildTree(treeInput);
        flattenBinaryTree(root);
        printLinkedList(root);
    }

    static TreeNode buildTree(String treeInput) {
        String[] nodes = treeInput.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            if (!nodes[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static void flattenBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.left != null) {
            flattenBinaryTree(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode rightMost = root.right;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = temp;
        }
        flattenBinaryTree(root.right);
    }

    static void printLinkedList(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
}
