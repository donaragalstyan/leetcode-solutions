class Solution {
    private List<List<String>> perms = new ArrayList<>();
    private List<String> result = new ArrayList<>();

    public String[] expand(String s) {
        parse(s, 0, new ArrayList<>());

        backtrack(0, new StringBuilder());

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void parse(String s, int idx, List<String> curr) {
        if (idx == s.length()) {
            return;
        }

        if (s.charAt(idx) == '{') {
            int end = s.indexOf('}', idx);

            String[] options = s.substring(idx + 1, end).split(",");

            perms.add(Arrays.asList(options));

            parse(s, end + 1, curr);
        } else {
            perms.add(Arrays.asList(String.valueOf(s.charAt(idx))));

            parse(s, idx + 1, curr);
        }
    }

    private void backtrack(int idx, StringBuilder path) {
        if (idx == perms.size()) {
            result.add(path.toString());
            return;
        }

        for (String option : perms.get(idx)) {
            int length = path.length();

            path.append(option);

            backtrack(idx + 1, path);

            path.setLength(length);
        }
    }
}
