import java.util.HashMap;
import java.util.Map;

public class MapExample2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("a",11);
        map.put("b",2);
        map.put("c",13);

        System.out.println(map);

        map.put("c",14);
        //varolan entry'deki value degistirilir

        System.out.println(map);

        map.remove("c");

        System.out.println(map);
    }
}