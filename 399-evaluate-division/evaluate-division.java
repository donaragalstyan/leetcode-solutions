class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> varIndex = new HashMap<>();
        int n = 0;
        for (List<String> eq : equations) {
            for (String var : eq) {
                if (!varIndex.containsKey(var)) {
                    varIndex.put(var, n++);
                }
            }
        }

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            uf.union(varIndex.get(a), varIndex.get(b), values[i]);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            if (!varIndex.containsKey(c) || !varIndex.containsKey(d)) {
                results[i] = -1.0;
                continue;
            }
            int cIdx = varIndex.get(c);
            int dIdx = varIndex.get(d);
            if (uf.find(cIdx) != uf.find(dIdx)) {
                results[i] = -1.0;
            } else {
                results[i] = uf.ratio[cIdx] / uf.ratio[dIdx];
            }
        }
        return results;
    }
}

class UnionFind {
    int[] root;
    double[] ratio;

    public UnionFind(int size) {
        root = new int[size];
        ratio = new double[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            ratio[i] = 1.0;
        }
    }

    public int find(int x) {
        if (root[x] != x) {
            int origParent = root[x];
            root[x] = find(root[x]);   
            ratio[x] *= ratio[origParent];  
        }
        return root[x];
    }

    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        root[rootX] = rootY;
        ratio[rootX] = value * ratio[y] / ratio[x];
    }
}