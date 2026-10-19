class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for (int[] e : prerequisites) {
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) q.add(i);

        int[] order = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;
            for (int next : graph.get(node))
                if (--indegree[next] == 0) q.add(next);
        }

        return idx == numCourses ? order : new int[0];
    }
}