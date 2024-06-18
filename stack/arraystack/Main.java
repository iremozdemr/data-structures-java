public class Main{
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        
        System.out.println("top element: " + stack.top());

        stack.push(1);
        System.out.println("top element: " + stack.top());

        stack.push(2);
        System.out.println("top element: " + stack.top());

        stack.push(3);
        System.out.println("top element: " + stack.top());

        System.out.println("size: " + stack.size());

        System.out.println("popped element: " + stack.pop());
        System.out.println("popped element: " + stack.pop());
        System.out.println("popped element: " + stack.pop());
        System.out.println("popped element: " + stack.pop());

        System.out.println("size: " + stack.size());
    }
}