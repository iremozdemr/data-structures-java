public class Josephus{
    public static void main(String[] args) {
        CircularQueue<String> queue1 = new CircularQueue<>();
        queue1.enqueue("a");
        queue1.enqueue("b");
        queue1.enqueue("c");
        queue1.enqueue("d");
        queue1.enqueue("e");
        queue1.enqueue("f");

        String winner1 = josephus(queue1,3);
        System.out.println("the winner is " + winner1);

        CircularQueue<String> queue2 = new CircularQueue<>();
        queue2.enqueue("a");
        queue2.enqueue("b");

        String winner2 = josephus(queue2,7);
        System.out.println("the winner is " + winner2);
    }

    public static String josephus(CircularQueue<String> queue, int k){
        if(queue.isEmpty()){
            return null;
        }
        else{
            while(queue.size() > 1){
                for(int i=0; i<k-1; i++){
                    queue.rotate();
                }
                String element = queue.dequeue();
                System.out.println(element + " is out");
            }
            return queue.first();
        }
    }
}