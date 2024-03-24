import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths of strings are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Create a map to store character frequencies of string s
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Count character frequencies in string s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Iterate through string t and decrement character frequencies in the map
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                // If a character in t is not found in the map, they can't be anagrams
                return false;
            }
            int count = map.get(c);
            if (count == 1) {
                map.remove(c);
            } else {
                map.put(c, count - 1);
            }
        }
        
        // If map is empty, all characters in s and t have been matched, they are anagrams
        return map.isEmpty();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(solution.isAnagram(s1, t1)); // Output: true
        
        String s2 = "rat";
        String t2 = "car";
        System.out.println(solution.isAnagram(s2, t2)); // Output: false
    }
}
