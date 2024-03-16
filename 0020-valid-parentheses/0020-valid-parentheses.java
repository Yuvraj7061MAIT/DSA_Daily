import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Base case
        if (s.length() == 0)
            return false;

        Stack<Character> valid = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                valid.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (valid.isEmpty()) {
                    return false;
                } else {
                    char top = valid.pop();
                    if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                        return false;
                    }
                }
            }
        }

        return valid.isEmpty();
    }
}
