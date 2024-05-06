public class Main{
    public static void main(String[] args) {

        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
    }
}