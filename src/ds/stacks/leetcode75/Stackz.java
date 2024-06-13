package ds.stacks.leetcode75;

import java.util.Stack;

public class Stackz {

    public static void main(String...args) {
        Stackz stackz = new Stackz();
        System.out.println(stackz.isBalanced("{{}}"));
        System.out.println(stackz.isBalanced("}{{}}"));
        System.out.println(stackz.isBalanced("{}{}"));
    }

    private boolean isBalanced(String inputString) {
        Stack<Character> paranthesisStack = new Stack<>();

        //TODO: check for inputString

        for (Character charOfString : inputString.toCharArray()) {
            if (charOfString.equals('{')) {
                paranthesisStack.push(charOfString);
            }
            if (charOfString.equals('}')) {
                if (!paranthesisStack.isEmpty()) {
                    Character poppedString = paranthesisStack.pop();
                    if (!poppedString.equals('{')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return paranthesisStack.isEmpty();
    }

}
