class Solution {
    // Array of less than 20 numbers
    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    // Array of tens multiples
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    // Array of thousands multiples
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        int i = 0;
        String words = "";
        
        // Process each chunk of the number (in thousands)
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        
        return words.trim();
    }
    
    // Helper function to process numbers below 1000
    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return belowTwenty[num] + " ";
        else if (num < 100)
            return tens[num / 10] + " " + helper(num % 10);
        else
            return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }
}
