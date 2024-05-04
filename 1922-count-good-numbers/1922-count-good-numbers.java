public class Solution {
    static long mod = 1000000007;

    // Helper function to compute power in logarithmic time
    static long power(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            y /= 2;
        }
        return res;
    }

    public int countGoodNumbers(long n) {
        long evenCount = 5; // There are 5 even digits (0, 2, 4, 6, 8)
        long primeCount = 4; // There are 4 prime digits (2, 3, 5, 7)

        long evenOptions = power(5, (n + 1) / 2); // Even indices can be any of the 5 even digits
        long primeOptions = power(4, n / 2); // Odd indices can be any of the 4 prime digits

        // The total count is the multiplication of even and prime counts
        long totalCount = (evenOptions * primeOptions) % mod;
        return (int) totalCount;
    }
}
