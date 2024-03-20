import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Create a map to store the mapping from Roman numerals to integer values
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        // Initialize the result variable
        int num = 0;
        
        // Iterate through the Roman numeral string
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanValues.get(s.charAt(i));
            // If the current value is less than the next one, subtract its value from the result
            if (i < s.length() - 1 && currentValue < romanValues.get(s.charAt(i + 1))) {
                num -= currentValue;
            } else {
                // Otherwise, add its value to the result
                num += currentValue;
            }
        }
        
        return num;
    }
}
