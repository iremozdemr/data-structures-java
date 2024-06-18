import java.util.Stack;

public class StackExample1{
    public static void main(String[] args) {

        //last in first out

        Stack<String> stack = new Stack<>();

        System.out.println(stack.empty());
        //stack bossa true doner
        //stack doluysa false doner

        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        //eleman ekler

        System.out.println(stack.search("item1"));
        //ilk eleman en sondadır
        System.out.println(stack.search("item2"));
        System.out.println(stack.search("item3"));
        System.out.println(stack.search("item7"));
        //stack'de bulunmuyorsa -1 döndürü

        System.out.println(stack.size());
        //stack'in eleman sayısını bulur

        System.out.println(stack);
        //tum stack elemanlarını ekrana yazar

        System.out.println(stack.peek());
        //elemanı silmeden en ustteki elemana bakar
        
        System.out.println(stack.pop());
        stack.pop();
        stack.pop(); 
        //elemanı siler

        System.out.println(stack.empty());

        //stack.pop();
        //empty stack exception
    }
}