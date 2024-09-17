class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to simplify the swap process
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // Identify the two nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Perform the swap
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Move the pointers forward for the next pair
            prev = firstNode;
            head = firstNode.next;
        }

        // Return the new head of the list
        return dummy.next;
    }
}
