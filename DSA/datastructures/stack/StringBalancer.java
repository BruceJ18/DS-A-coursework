package DSA.datastructures.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringBalancer {

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[','{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char chr : input.toCharArray()) {
            if (isLeftBracket(chr))
                stack.push(chr);

            if (isRightBracket(chr)) {
                if (stack.isEmpty()) return false;

                var top = stack.pop();
                if (isSetOfBrackets(top, chr)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isSetOfBrackets(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private boolean isRightBracket(char chr) {
        return rightBrackets.contains(chr);
    }

    private boolean isLeftBracket(char chr) {
        return leftBrackets.contains(chr);
    }
}
