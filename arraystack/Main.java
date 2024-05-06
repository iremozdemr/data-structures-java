public class Main{

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);

        try {
            // Push elements onto the stack
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);

            System.out.println("Original Stack: " + stack.toString());

            // Reverse the stack
            stack.reverse(stack);

            System.out.println("Reversed Stack: " + stack.toString());

            // Pop elements from the reversed stack
            while (!stack.isEmpty()) {
                System.out.println("Popped element: " + stack.pop());
            }

            // Try to pop from an empty stack
            System.out.println("Popped element from an empty stack: " + stack.pop());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        String expression1 = "((()))"; 
        String expression2 = "(()))"; 

        System.out.println("Expression 1 is matched: " + isMatched(expression1));
        System.out.println("Expression 2 is matched: " + isMatched(expression2));
    }

    public static boolean isMatched(String string){
        Stack<Character> stack = new Stack<>(string.length());
        char[] array = new char[string.length()];

        for(int i = 0; i<string.length(); i++){
            array[i] = string.charAt(i);
        }

        for(int i = 0; i<string.length(); i++){
            if(array[i] == '(' || array[i] == '{' || array[i] == '['){
                stack.push(array[i]);
            }
            else if(array[i] == ')' || array[i] == '}' || array[i] == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    if(array[i] == ')' && stack.top() == '('){
                        stack.pop();
                    }
                    else if(array[i] == ']' && stack.top() == '['){
                        stack.pop();
                    }
                    else if(array[i] == '}' && stack.top() == '{'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }

        if(stack.isEmpty()){
                return true;
        }
        return false;
    }
}
