import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                int[] componentInfo = dfs(node, graph, visited);

                int vertices = componentInfo[0];
                int degreeSum = componentInfo[1];

                if (degreeSum == vertices * (vertices - 1)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private int[] dfs(
        int node,
        List<List<Integer>> graph,
        boolean[] visited
    ) {
        visited[node] = true;

        int vertices = 1;
        int degreeSum = graph.get(node).size();

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                int[] result = dfs(neighbor, graph, visited);

                vertices += result[0];
                degreeSum += result[1];
            }
        }

        return new int[] {vertices, degreeSum};
    }
}