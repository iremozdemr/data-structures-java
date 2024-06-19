 CircularQueue<String> queue2 = new CircularQueue<>();
        queue2.enqueue("a");
        queue2.enqueue("b");

        String winner2 = josephus(queue1,7);
        System.out.println("the winner is " + winner2);