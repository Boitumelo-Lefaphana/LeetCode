class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Base case
        if (head == null) {
            return null;
        }

        // Find the middle element of the list
        ListNode mid = findMiddle(head);
        
        // The middle element becomes the root
        TreeNode node = new TreeNode(mid.val);
        
        // Base case for when there's only one element in the linked list
        if (head == mid) {
            return node;
        }
        
        // Recursively build the left and right subtrees
        node.left = sortedListToBST(head);  // Left subtree using left half of the list
        node.right = sortedListToBST(mid.next);  // Right subtree using right half of the list

        return node;
    }
    
    // Helper function to find the middle element of the linked list
    private ListNode findMiddle(ListNode head) {
        // Use two pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Disconnect the left half from the middle
        if (prev != null) {
            prev.next = null;
        }
        
        return slow;
    }
}
