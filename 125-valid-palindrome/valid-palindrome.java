class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            if(Character.isLetter(s.charAt(i))) {
                stack.add(Character.toLowerCase(s.charAt(i)));
            } else if (Character.isDigit(s.charAt(i))) {
                stack.add(s.charAt(i));
            }
        }

        // || Character.isDigit(s.charAt(i))

        while (stack.size() > 1) {
            if (stack.removeFirst() != stack.removeLast()) {
                return false;
            }
        }
        return true;
    }
}