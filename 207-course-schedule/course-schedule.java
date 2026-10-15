class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqToCourse = new HashMap<>();

        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            List<Integer> courses = prereqToCourse.getOrDefault(prereq, new ArrayList<>());
            courses.add(course);
            prereqToCourse.put(prereq, courses);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            if (hasCycle(i, prereqToCourse, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, Map<Integer, List<Integer>> graph, int[] state) {
        if (state[course] == 1) {
            return true;
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        for (int next : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(next, graph, state)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}