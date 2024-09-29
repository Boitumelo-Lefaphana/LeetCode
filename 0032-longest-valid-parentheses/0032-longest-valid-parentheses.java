class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Initial base to calculate the valid lengths
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Push the index of the '('
                stack.push(i);
            } else {
                // Pop the last index
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If stack is empty, push the current index as base for next valid parentheses
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
