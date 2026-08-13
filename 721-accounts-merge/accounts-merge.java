class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailToId = new HashMap<>();
        HashMap<Integer, String> IdToName = new HashMap<>();

        for (List<String> a : accounts) {
            for(int i = 1; i < a.size(); i++) {
                emailToId.putIfAbsent(a.get(i), emailToId.size());
                int id = emailToId.get(a.get(i));
                IdToName.putIfAbsent(id, a.get(0));
            }
        }

        UnionFind uF = new UnionFind(emailToId.size());
        for (List<String> a : accounts) {
            int firstId = emailToId.get(a.get(1));
            for (int i = 2; i < a.size(); i++) {
                uF.union(firstId, emailToId.get(a.get(i)));
            }
        }

        Map<Integer, List<Integer>> rootToIds = new HashMap<>();
        for (int id = 0; id < emailToId.size(); id++) {
            int root = uF.find(id);
            rootToIds.computeIfAbsent(root, k -> new ArrayList<>()).add(id);
        }


        Map<Integer, String> idToEmail = new HashMap<>();
        for (Map.Entry<String, Integer> e : emailToId.entrySet()) {
            idToEmail.put(e.getValue(), e.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for (List<Integer> ids : rootToIds.values()) {
            List<String> emails = new ArrayList<>();
            for (int id : ids) {
                emails.add(idToEmail.get(id));
            }
            Collections.sort(emails);
            emails.add(0, IdToName.get(ids.get(0)));
            result.add(emails);
        }

        return result;

    }
}


class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; ++i) {
            root[i] = i;
            rank[i] = 1; // every node starts with a rank 1
        }
    }


    public int find(int x) {
        if (x == root[x]) {
            return x;
        }

        return root[x] = find(root[x]);
    }


    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}