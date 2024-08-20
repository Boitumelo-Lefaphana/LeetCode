import java.util.ArrayList;
import java.util.List;

class Solution {
    // Digit to letter mapping
    private static final String[] digitToLetters = {
        "",    // 0
        "",    // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };
    
    public List<String> letterCombinations(String digits) {
        // Resultant list to store combinations
        List<String> result = new ArrayList<>();
        
        // If the input is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start backtracking with an empty string and index 0
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }
    
    private void backtrack(List<String> result, String digits, StringBuilder currentCombination, int index) {
        // Base case: if the combination length is equal to digits length
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }
        
        // Get the letters corresponding to the current digit
        String possibleLetters = digitToLetters[digits.charAt(index) - '0'];
        
        // Loop through each letter and recurse
        for (char letter : possibleLetters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(result, digits, currentCombination, index + 1);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // backtrack
        }
    }
}
