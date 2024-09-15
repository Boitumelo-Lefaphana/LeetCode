import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;  // Return an empty list if the tree is empty.
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;  // A flag to toggle the direction
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // Insert nodes in the current level according to the traversal direction.
                if (leftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.addFirst(currentNode.val);  // Add to the front for right-to-left.
                }
                
                // Add the children of the current node to the queue for the next level.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            // Add the current level to the result list.
            result.add(currentLevel);
            
            // Toggle the direction for the next level.
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}
