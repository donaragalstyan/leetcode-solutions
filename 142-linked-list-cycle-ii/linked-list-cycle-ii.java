/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        ListNode ans = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            ListNode start = head;
            if (start == fast) {
                return start;
            }
            while (fast != null && fast.next != null) {
                start = start.next;
                fast = fast.next;
                if (start == fast) {
                    ans = start;
                    break;
                }
            }
        } else {
            return null;
        }

        return ans;
    }
}