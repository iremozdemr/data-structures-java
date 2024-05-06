import java.util.Hashtable;

public class HashTableExamples{
    public static void main(String[] args) {
        
        //Hashtable1<Integer,String> hashtable1 = new Hashtable<>();
        //Hashtable1<Integer,String> hashtable2 = new Hashtable<>(10);
        //Hashtable1<Integer,String> hashtable3 = new Hashtable<>(10,0.5f);

        Hashtable<Integer,String> hashtable1 = new Hashtable<>();

        hashtable1.put(100, "student1");
        hashtable1.put(20, "student2");
        hashtable1.put(3, "student3");
        hashtable1.put(42, "student4");
        hashtable1.put(42, "student5");
        hashtable1.put(42, "student6");

        hashtable1.remove(42);

        int i = 1;
        for(Integer key : hashtable1.keySet()){
            System.out.print("key" + i + " = " + key + " ");
            System.out.println("hashcode" + i + " = " + key.hashCode());
            i++;
        }
        //integerlarin hashcode u kendisine esittir

        System.out.println(hashtable1.keySet());


        Hashtable<String,String> hashtable2 = new Hashtable<>();

        hashtable2.put("97", "student1");
        hashtable2.put("98", "student2");
        hashtable2.put("99", "student3");

        i = 1;
        for(String key : hashtable2.keySet()){
            System.out.print("key" + i + " = " + key + " ");
            System.out.println("hashcode" + i + " = " + key.hashCode());
            i++;
        }
        //stringlerin hashcode u kendisine esit degildir

        System.out.println(hashtable2.keySet());
    }
}