class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head, to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers starting at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move the first pointer `n` steps ahead
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        
        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Skip the nth node from the end
        second.next = second.next.next;
        
        // Return the head of the modified list
        return dummy.next;
    }
}
