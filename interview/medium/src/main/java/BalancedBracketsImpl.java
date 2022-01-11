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
        return false;
    }
}
