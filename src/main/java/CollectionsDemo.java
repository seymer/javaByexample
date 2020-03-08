import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        // ArrayList
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        a1.add(111);
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        // LinkedList
        List l1 = new LinkedList<String>();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        l1.add(12122);
        System.out.println();
        System.out.println("LinkedList Elements");
        System.out.print("\t" + l1);

        // HashSet
        Set s1 = new HashSet<String>();
        s1.add("Zara");
        s1.add("Mahnaz");
        s1.add("Ayan");
        s1.add(1221212);
        System.out.println();
        System.out.println("Set ELements");
        System.out.print("\t" + s1);

        // HashMap
        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        System.out.println();
        System.out.println("Map Elements");
        System.out.println("\t" + m1);


    }
}
