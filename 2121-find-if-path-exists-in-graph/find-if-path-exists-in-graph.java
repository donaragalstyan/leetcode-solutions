class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }

    private boolean dfs(int node, int target, Map<Integer, List<Integer>> graph, boolean[] visited) {

        if (node == target) {
            return true;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, target, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}