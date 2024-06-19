import java.util.*;

class Main {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0; // Counter to track how many courses are taken
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int neighbor : adjacencyList.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCourses = scanner.nextInt();
        int numPrerequisites = scanner.nextInt();

        int[][] prerequisites = new int[numPrerequisites][2];
        for (int i = 0; i < numPrerequisites; i++) {
            prerequisites[i][0] = scanner.nextInt();
            prerequisites[i][1] = scanner.nextInt();
        }

        boolean result = canFinish(numCourses, prerequisites);
        System.out.println(result ? "True" : "False");
    }
}
