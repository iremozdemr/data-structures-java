import java.util.ArrayDeque;
import java.util.Stack;

public class StackExample2 {
    public static void main(String[] args) {

        Stack stack1 = new Stack();
        Stack<String> stack2 = new Stack<>();
        ArrayDeque<String> stack3 = new ArrayDeque<>();

        stack1.push("veri1");
        stack1.push("veri2");
        stack1.push("veri3");
        System.out.println(stack1.peek());
        System.out.println(stack1.search("veri"));
        System.out.println(stack1.pop());

        stack2.push("veri1");
        stack2.push("veri2");
        stack2.push("veri3");
        System.out.println(stack2.peek());
        System.out.println(stack2.search("veri"));
        System.out.println(stack2.pop());

        stack3.push("veri1");
        stack3.push("veri2");
        stack3.push("veri3");
        System.out.println(stack3.peek());
        //System.out.println(stack3.search("veri"));
        System.out.println(stack3.pop());
    }
}
