class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();
                if (!((open == '(' && ch == ')') ||
                      (open == '[' && ch == ']') ||
                      (open == '{' && ch == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}