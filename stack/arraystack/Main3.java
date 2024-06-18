public class Main3 {
    public static void main(String[] args) {
        ArrayStack<Character> stack = new ArrayStack<>();
        System.out.println(isMatched("()(( )){([( )])}")); 
        System.out.println(isMatched("((( )(( )){([( )])}))")); 
        System.out.println(isMatched(")(()){([()])}")); 
        System.out.println(isMatched("({[])}")); 
        System.out.println(isMatched("(")); 
    }

    public static boolean isMatched(String string){
        ArrayStack<Character> stack = new ArrayStack<>(string.length());

        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    char top = stack.pop();
                    if(top == '(' && c != ')'){
                        return false;
                    }
                    if(top == '{' && c != '}'){
                        return false;
                    }
                    if(top == '[' && c != ']'){
                        return false;
                    }
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}