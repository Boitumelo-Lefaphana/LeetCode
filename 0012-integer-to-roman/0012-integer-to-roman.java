class Solution {
    public String intToRoman(int num) {
        // Create arrays for Roman numerals and their respective integer values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Iterate over the values array
        for (int i = 0; i < values.length; i++) {
            // While the number is greater than or equal to the current value
            while (num >= values[i]) {
                // Subtract the value from the number
                num -= values[i];
                // Append the corresponding symbol to the result
                roman.append(symbols[i]);
            }
        }
        
        // Return the final Roman numeral as a string
        return roman.toString();
    }
}
