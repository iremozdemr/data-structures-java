import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] array = {4, 8, 15, 16, 23, 42};

        System.out.println("before reverse(): " + Arrays.toString(array));

        reverse(array);

        System.out.println("after reverse(): " + Arrays.toString(array));
    }

    //reversing an array using a stack
    public static void reverse(int[] array){
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i=0; i<array.length; i++){
            stack.push(array[i]);
        }

        for(int i=0; i<array.length; i++){
            array[i] = stack.pop();
        }
    }
}