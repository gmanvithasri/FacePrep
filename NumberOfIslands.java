import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int islands = countIslands(matrix);
        System.out.println(islands);

        scanner.close();
    }

    private static int countIslands(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    markVisited(matrix, i, j);
                }
            }
        }

        return count;
    }

    private static void markVisited(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || matrix[row][col] != 1) {
            return;
        }
        matrix[row][col] = -1;
        markVisited(matrix, row + 1, col);
        markVisited(matrix, row - 1, col);
        markVisited(matrix, row, col + 1);
        markVisited(matrix, row, col - 1);
        markVisited(matrix, row + 1, col + 1);
        markVisited(matrix, row + 1, col - 1);
        markVisited(matrix, row - 1, col + 1);
        markVisited(matrix, row - 1, col - 1);
    }
}
