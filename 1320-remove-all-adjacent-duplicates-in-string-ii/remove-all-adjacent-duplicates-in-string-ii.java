class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> count = new Stack();

        StringBuilder sb = new StringBuilder(s);
        count.push(1);
        
        for (int i = 1; i < sb.length(); ++i) {
            if (i > 0 && sb.charAt(i - 1) == sb.charAt(i)) {
                int rem = count.pop();
                count.push(rem + 1);
            } else {
                count.push(1);
            }

            if (count.peek() == k) {
                sb.delete(i - k + 1, i + 1);
                int top = count.pop();
                i = i - k;
            }
        }

        String returned = new String(sb);

        return returned;
    }
}