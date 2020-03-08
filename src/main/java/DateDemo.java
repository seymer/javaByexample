import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());

        // display time and date
        String str = String.format("Current Date/Time: %tc", date);
        System.out.printf(str);

        System.out.println();

        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);

        System.out.println();

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(dNow));

        SimpleDateFormat fts = new SimpleDateFormat("yyyy-MM-dd");
        String input = args.length == 0 ? "1818-11-11" : args[0];

        System.out.print(input + "Parses as");
        Date t;
        try {
            t = fts.parse(input);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + fts);
        }

        try {
            System.out.println(new Date() + "\n");
            Thread.sleep(5*60*10);
            System.out.println(new Date() + "\n");
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }

        try {
            long start = System.currentTimeMillis();
            System.out.println(new Date() + "\n");

            Thread.sleep(5*60*10);
            System.out.println(new Date() + "\n");

            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("Difference is : " + diff);
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }



    }
}
