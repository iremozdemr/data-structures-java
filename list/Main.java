public class Main{
    public static void main(String[] args) {
        PositionalList<Integer> list = new PositionalList<>();

        Position<Integer> a = list.addFirst(5);
        Position<Integer> b = list.addLast(10);
        Position<Integer> c = list.addFirst(7);
        Position<Integer> d = list.addLast(11);

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.first());
        System.out.println(list.last());
        System.out.println(list.before(c));
        System.out.println(list.before(d));
        System.out.println(list.after(c));
        System.out.println(list.after(d));
        list.set(d,4);
        System.out.println(list);
        list.set(c,1);
        System.out.println(list);
        list.remove(c);
        System.out.println(list);
        list.remove(d);
        System.out.println(list);
        list.addAfter(b, 9);
        System.out.println(list);
        list.addBefore(a,1);
        System.out.println(list);
    }
}
