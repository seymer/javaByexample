import java.util.ArrayList;

public class JavaExample {

    public static void main(String[] args) {
        ArrayList<String> alist = new ArrayList<String>();
        alist.add("steve");
        alist.add("Time");
        alist.add("Lucy");
        alist.add("Pat");

        System.out.println(alist);

        alist.add(2, "Mu");

        System.out.println(alist);

        alist.remove(2);

        System.out.println(alist);

        for (String str:alist)
            System.out.println(str);

        alist.set(1, "bai");

        System.out.println(alist);

        int pos = alist.indexOf("Pat");
        System.out.println(pos);

    }
}
