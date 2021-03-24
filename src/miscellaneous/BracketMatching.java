package miscellaneous;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class BracketMatching {

    public static void main(String[] args) {
        System.out.println(isStringValid("(){({})(())}[](())"));
    }


    public static boolean isParenthesisStringValid(String str) {
        int overallCount = 0, len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '(')
                overallCount++;
            else
                overallCount--;
            if (overallCount < 0)
                return false;
        }
        if (overallCount == 0)
            return true;
        return false;
    }

    public static boolean isStringValid(String str) {
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');

        Stack<Character> stack = new Stack<>();
        char current, top;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            current = str.charAt(i);

            if (charMap.get(current) == null) {
                stack.push(current);
            } else {
                if (stack.isEmpty())
                    return false;
                top = stack.pop();
                if (top != charMap.get(current))
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
