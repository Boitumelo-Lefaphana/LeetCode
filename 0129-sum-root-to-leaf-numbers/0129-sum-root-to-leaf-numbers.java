class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, return 0
        if (node == null) {
            return 0;
        }
        
        // Update the current sum by appending the node's value
        currentSum = currentSum * 10 + node.val;
        
        // If it's a leaf node, return the currentSum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // Recur for left and right subtrees
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);
        
        // Return the total sum from both subtrees
        return leftSum + rightSum;
    }
}
