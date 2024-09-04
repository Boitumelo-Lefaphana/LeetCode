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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        // Dummy node initialization to ease the edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize pointers
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;
        
        while (true) {
            ListNode groupStart = curr;
            ListNode groupEnd = curr;
            
            // Check if there are enough nodes left to reverse
            for (int i = 1; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }
            
            // If there are fewer than k nodes left, we're done
            if (groupEnd == null) {
                break;
            }
            
            // Mark the next group's start
            ListNode nextGroupStart = groupEnd.next;
            
            // Reverse the current group
            reverse(groupStart, groupEnd);
            
            // Connect the previous group with the current reversed group
            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;
            
            // Move to the next group
            prevGroupEnd = groupStart;
            curr = nextGroupStart;
        }
        
        return dummy.next;
    }
    
    // Helper function to reverse the list from start to end
    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode next = null;
        
        while (prev != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
