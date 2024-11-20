class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder columnTitle = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based indexing
            int remainder = columnNumber % 26;
            char letter = (char) (remainder + 'A'); // Map to character
            columnTitle.append(letter);
            columnNumber /= 26; // Move to the next place value
        }

        return columnTitle.reverse().toString(); // Reverse to get the correct order
    }
}
