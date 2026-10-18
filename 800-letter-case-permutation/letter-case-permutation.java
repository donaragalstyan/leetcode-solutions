class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrack(s, 0, new StringBuilder(""));
        return ans;
    }

    private void backtrack(String s, int idx, StringBuilder curr) {
        if (idx == s.length()) {
            ans.add(curr.toString());
            return;
        }

        char c = s.charAt(idx);
        if (Character.isDigit(c)) {
            curr.append(c);
            backtrack(s, idx + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        curr.append(Character.toLowerCase(c));
        backtrack(s, idx + 1, curr);
        curr.deleteCharAt(curr.length() - 1);

        curr.append(Character.toUpperCase(c));
        backtrack(s, idx + 1, curr);
        curr.deleteCharAt(curr.length() - 1);
    }
}