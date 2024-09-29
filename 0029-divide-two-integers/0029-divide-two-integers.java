class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Convert both dividend and divisor to positive
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        
        int quotient = 0;
        
        // Use bitwise shift to optimize the division process
        while (dividendL >= divisorL) {
            long tempDivisor = divisorL;
            int multiple = 1;
            
            // Shift divisor until it's larger than the remaining dividend
            while (dividendL >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the shifted divisor from the dividend and add the multiple to the quotient
            dividendL -= tempDivisor;
            quotient += multiple;
        }
        
        // Adjust the sign of the quotient
        return negative ? -quotient : quotient;
    }
}
