import java.lang.reflect.Array;
import java.util.*;

public class T{

    public static void main(String[] args) {
        //T t = new T();
        //t.form();
        //t.sort();
        Thread thread1 = new Thread(new Runner());
        thread1.start();
        Thread thread2 = new Thread(new Runner());
        thread2.start();
    }

    class Number implements Comparable<Number>{
        public int num;
        public String name;
        Number(int num, String name){
            this.num=num;
            this.name=name;
        }

        @Override
        public boolean equals(Object obj) {
            Number ob = (Number)obj;
            return (this.name.equalsIgnoreCase(ob.name) && this.num==ob.num);
        }



        @Override
        public String toString() {
            return "Number{" +
                    "num=" + num +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Number o) {
            return this.name.compareTo(o.name);
        }
    }
    private void sort() {
        int[] array = {1,2,3};

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,7,10,3,4,5));
        Collections.sort(list);
        System.out.println(list);

        List<Number> list2 = new ArrayList<>(
                Arrays.asList(new Number(1,"one"),
                new Number(10, "ten"),
                        new Number(50,"fifty"),
                        new Number(4, "four")));

        Collections.sort(list2, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list2);
    }

    public void form(){
        Map<Integer, String> l = new TreeMap<>();
        l.put(1,"one");
        l.put(2,"two");
        l.put(1,null);
        for(Map.Entry o:l.entrySet()){
            System.out.println(o.getKey()+"-"+ o.getValue());
        }
    }
}
