class Solution {
    public int minSteps(int n) {
        int result = 0;
        int divisor = 2;
        
        while (n > 1) {
            while (n % divisor == 0) {
                result += divisor;
                n /= divisor;
            }
            divisor++;
        }
        
        return result;
    }
}
