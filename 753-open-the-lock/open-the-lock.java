class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (dead.contains("0000")) {
            return -1;
        }

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return turns;
                }

                for (int j = 0; j < 4; j++) {
                    char[] chars = current.toCharArray();
                    int digit = chars[j] - '0';

                    chars[j] = (char) ('0' + (digit + 1) % 10);
                    String next = new String(chars);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }

                    // Rotate backward
                    chars[j] = (char) ('0' + (digit + 9) % 10);
                    next = new String(chars);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            turns++;
        }

        return -1;
    }
}