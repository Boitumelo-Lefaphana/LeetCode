class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) return;
        
        // Add the current node's value to the path
        path += node.val;
        
        // If it's a leaf node, add the path to the result list
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            // If it's not a leaf, continue to traverse the left and right children
            path += "->";
            dfs(node.left, path, paths);
            dfs(node.right, path, paths);
        }
    }
}
