class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // DP table where dp[i][j] means if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Fill in the first row (matching empty string with the pattern)
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                if (pChar == '?') {
                    // '?' matches any single character
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // '*' can match empty sequence (dp[i][j-1]) or match current character (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    // Match if current characters are the same
                    dp[i][j] = (sChar == pChar) && dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
