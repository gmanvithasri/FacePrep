import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    System.out.print(node.val + " ");
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            for (int val : level) {
                System.out.print(val + " ");
            }
            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] values = scanner.nextLine().split(" ");
        TreeNode root = buildTree(values);
        zigzagLevelOrder(root);
        scanner.close();
    }

    public static TreeNode buildTree(String[] values) {
        int n = values.length;
        if (n == 0 || values[0].equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            TreeNode node = queue.poll();
            if (!values[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;
            if (i < n && !values[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
