import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println(0);
            return;
        }

        String[] input = line.split("\\s+");
        TreeNode root = constructTree(input);

        if (root == null) {
            System.out.println(0);
            return;
        }

        int totalSum = solution.sumNumbers(root);
        System.out.println(totalSum);
    }

    private static TreeNode constructTree(String[] input) {
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;

        if (!isNumeric(input[0]) || Integer.parseInt(input[0]) < 0) {
            return null;
        }

        root = new TreeNode(Integer.parseInt(input[0]));
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            index++;
            if (index < input.length && isNumeric(input[index]) && Integer.parseInt(input[index]) >= 0) {
                node.left = new TreeNode(Integer.parseInt(input[index]));
                queue.offer(node.left);
            }

            index++;
            if (index < input.length && isNumeric(input[index]) && Integer.parseInt(input[index]) >= 0) {
                node.right = new TreeNode(Integer.parseInt(input[index]));
                queue.offer(node.right);
            }
        }

        return root;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
