public class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. If x is negative, it can't be a palindrome because the '-' sign will make it different when reversed.
        // 2. If x is a multiple of 10 and not zero, it can't be a palindrome because the reversed number will have a leading zero.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        // Reverse the second half of the number
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can simply remove the last digit of reversedNumber
        // to get rid of the middle digit.
        return x == reversedNumber || x == reversedNumber / 10;
    }
}
