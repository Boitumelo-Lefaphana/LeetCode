import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    // Constructor: initialize the stack and push all the left nodes
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }
    
    // Move to the next smallest element
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushAllLeft(node.right); // push all the left children of the right child
        }
        return node.val;
    }
    
    // Check if there are more elements to visit
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    // Helper method to push all the left children of a node onto the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
