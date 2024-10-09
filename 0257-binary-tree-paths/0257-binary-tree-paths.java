class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // Call the helper function to build paths
        constructPaths(root, "", result);
        return result;
    }

    // Helper function to recursively build paths
    private void constructPaths(TreeNode node, String path, List<String> result) {
        if (node != null) {
            // Append this node's value to the path
            path += Integer.toString(node.val);
            
            // If it's a leaf node, add the current path to the result
            if (node.left == null && node.right == null) {
                result.add(path);
            } else {
                // Otherwise, continue the path with '->'
                path += "->";
                
                // Recursively call for left and right children
                constructPaths(node.left, path, result);
                constructPaths(node.right, path, result);
            }
        }
    }
}
