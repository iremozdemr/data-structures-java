public class Main{
    public static void main(String[] args) {
        Map<Integer, String> map = new Map<>();

        // Adding elements to the map
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Displaying the elements
        System.out.println("Elements in the map:");
        for (Integer key : map.keys()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Removing an element
        System.out.println("\nRemoving key 2...");
        String removedValue = map.remove(2);
        System.out.println("Value removed: " + removedValue);

        // Displaying the updated elements
        System.out.println("\nElements in the map after removal:");
        for (Integer key : map.keys()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}