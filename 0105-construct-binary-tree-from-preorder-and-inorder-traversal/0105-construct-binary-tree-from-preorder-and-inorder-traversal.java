import java.util.HashMap;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store the index of each value in inorder for O(1) access
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        // Helper function to build the tree recursively
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                     int[] inorder, int inStart, int inEnd, 
                                     HashMap<Integer, Integer> inorderIndexMap) {
        // Base case: if there are no elements to process
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // The root value is the first element of the current preorder segment
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of the root value in the inorder array
        int rootIndex = inorderIndexMap.get(rootValue);
        
        // Calculate the number of nodes in the left subtree
        int leftSubtreeSize = rootIndex - inStart;
        
        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                                    inorder, inStart, rootIndex - 1, inorderIndexMap);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                                     inorder, rootIndex + 1, inEnd, inorderIndexMap);
        
        return root;
    }
}
