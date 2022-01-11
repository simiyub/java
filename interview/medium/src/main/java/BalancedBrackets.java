/**
 * This function takes a string and returns a boolean true if the
 * parenthesis in the string are balanced. This means every open bracket
 * has a matching closing bracket in the string.
 * "([])(){}(())()()" is an example of a matching bracket.
 * "([])(){}(()()()" is not.
 * */
public interface BalancedBrackets {
    boolean balanced(String string);

}
