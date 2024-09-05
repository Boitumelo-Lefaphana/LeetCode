class Solution {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Handle negative powers
        if (n < 0) {
            x = 1 / x;
            // Handle edge case where n is Integer.MIN_VALUE
            n = -(n + 1);  // Add 1 to prevent overflow
            return x * myPow(x, n); // Compensate the addition by multiplying once with x
        }

        // Recursive case: Exponentiation by Squaring
        double half = myPow(x, n / 2);
        
        // If n is even
        if (n % 2 == 0) {
            return half * half;
        } else {
            // If n is odd
            return half * half * x;
        }
    }
}
