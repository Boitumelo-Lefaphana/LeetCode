class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1, return the original string as no conversion is needed
        if (numRows == 1) return s;

        // Create an array of StringBuilder to hold the characters of each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Variables to track the current row and the direction of traversal
        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string, appending characters to the appropriate row
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // Change direction when you reach the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
