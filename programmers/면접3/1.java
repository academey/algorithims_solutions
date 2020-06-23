import java.util.*;

public class ValidBrackets
{
    private static HashMap<Character, Character> hashMap = new HashMap<>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};
    
    public static boolean isValid(String brackets) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < brackets.length(); i++) {
            Character ch = new Character(brackets.charAt(i));            
            if (stack.empty()) {
                stack.push(ch);
                continue;
            }
            
            Character peek = stack.peek();
            if (!hashMap.containsKey(peek)) {
                return false;
            }
            
            Character peekPartner = hashMap.get(peek);
            if (peekPartner.equals(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        return stack.empty();
    }
    
    public static void main(String[] args) {
        System.out.println(ValidBrackets.isValid("[{()}]"));
    }
}