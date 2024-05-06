public class Main{
    public static void main(String[] args) {
        
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add("a");
        dynamicArray.add("a");
        dynamicArray.add("a");
        dynamicArray.add("b");
        dynamicArray.add("a");
        dynamicArray.add("c");

        System.out.println(dynamicArray.size);
        System.out.println(dynamicArray.capacity);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray.search("b"));
        dynamicArray.remove("b");
        dynamicArray.insert(3, "c");
    }
}