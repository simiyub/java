import java.util.*;

/**
 * O(n) T and O(1) S as we walk through the string checking
 * every character to determine if it is a parenthesis and if it is,
 * we add to the stack if it is an opening parenthesis
 * or check if it matches the opening parenthesis. Soon as we find a closing
 * bracket that doesn't match or finish and the stack is empty, we return false.
 * Otherwise, we return true.
 * */
public class BalancedBracketsImpl implements BalancedBrackets {
    @Override
    public boolean balanced(String string) {
        Map<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put('{','}');
        parenthesis.put('[',']');
        parenthesis.put('(',')');
        Deque<Character> stack = new ArrayDeque<>();
        for (Character character:string.toCharArray()){
            if(parenthesis.keySet().contains(character)) stack.push(character);
            else if (parenthesis.values().contains(character)){
                Character current = stack.peek();
                if(current==null || !parenthesis.get(current).equals(character)) return false;
                else stack.remove();
            }
        }
        return stack.isEmpty();

    }
}
