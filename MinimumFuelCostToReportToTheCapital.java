import java.util.*;

class Solution {
    public int minFuel(int[][] roads, int n, int seats) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            graph.computeIfAbsent(city1, k -> new ArrayList<>()).add(city2);
            graph.computeIfAbsent(city2, k -> new ArrayList<>()).add(city1);
        }

        // Find the maximum depth from the capital city
        int maxDepth = dfs(0, -1, graph);

        // Minimum number of liters of fuel needed is the maximum depth multiplied by the number of seats
        return (maxDepth + seats - 1) / seats * seats; // Round up to the nearest multiple of seats
    }

    private int dfs(int city, int parent, Map<Integer, List<Integer>> graph) {
        int maxDepth = 0;
        for (int neighbor : graph.getOrDefault(city, Collections.emptyList())) {
            if (neighbor != parent) {
                int depth = dfs(neighbor, city, graph);
                maxDepth = Math.max(maxDepth, depth);
            }
        }
        return maxDepth + 1; // Increment depth by 1 for the current city
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of cities
        int[][] roads = new int[n - 1][2]; // Number of roads = number of cities - 1
        for (int i = 0; i < n - 1; i++) {
            roads[i][0] = scanner.nextInt();
            roads[i][1] = scanner.nextInt();
        }

        int seats = scanner.nextInt(); // Number of seats in each car

        Solution solution = new Solution();
        int minFuel = solution.minFuel(roads, n, seats);
        System.out.println(minFuel);

        scanner.close();
    }
}
