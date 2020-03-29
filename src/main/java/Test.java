import java.util.Arrays;

public class Test {

    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] myList = Test.reverse(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(myList));

        Integer x = 5;

        // Returns byte primitive data type
        System.out.println(x.byteValue());

        // Returns short primitive data type
        System.out.println(x.shortValue());

        // Returns int primitive data type
        System.out.println(x.intValue());

        // Returns double primitive data type
        System.out.println(x.doubleValue());

        // Returns float primitive data type
        System.out.println(x.floatValue());

        // Return long primitive data type
        System.out.println(x.longValue());

        System.out.println(System.getenv());

        System.out.println("x = " + x);
        System.out.println(System.getProperties());
    }
}
