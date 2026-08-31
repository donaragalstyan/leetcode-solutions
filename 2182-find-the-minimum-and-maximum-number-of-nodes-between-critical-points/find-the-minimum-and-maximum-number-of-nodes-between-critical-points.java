/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int firstCritical = -1;
        int previousCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        while (curr.next != null) {

            boolean isMax = curr.val > prev.val
                    && curr.val > curr.next.val;

            boolean isMin = curr.val < prev.val
                    && curr.val < curr.next.val;

            if (isMax || isMin) {

                if (firstCritical == -1) {
                    firstCritical = index;
                    previousCritical = index;
                } else {
                    int distance = index - previousCritical;

                    minDistance = Math.min(minDistance, distance);

                    maxDistance = index - firstCritical;

                    previousCritical = index;
                }
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (maxDistance == -1) {
            return new int[] {-1, -1};
        }

        return new int[] {minDistance, maxDistance};
    }
}