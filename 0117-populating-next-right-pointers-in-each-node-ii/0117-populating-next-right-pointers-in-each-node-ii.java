class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the root node
        Node current = root;
        while (current != null) {
            // Dummy node to track the start of the next level
            Node dummy = new Node(0);
            Node tail = dummy;
            
            // Connect the nodes on the current level
            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }
                
                // Move to the next node in the current level
                current = current.next;
            }
            
            // Move to the next level
            current = dummy.next;
        }
        
        return root;
    }
}
