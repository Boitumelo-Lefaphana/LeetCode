class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Start from the second last row and move upwards
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // Update the current element by adding the minimum of the two adjacent elements from the row below
                int minBelow = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, triangle.get(row).get(col) + minBelow);
            }
        }
        
        // The top element contains the minimum path sum
        return triangle.get(0).get(0);
    }
}
