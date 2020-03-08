public class JavaIntList {
    static class Node {
        public Node next;
        public int value;
    }

    public Node head;
    public int size;

//    public int getSize() {
//        Node n = head;
//        int i = 0;
//        while (n != null) {
//            n = n.next;
//            i++;
//        }
//        return i;
//    }


    public static void main(String[] args) {
        JavaIntList myList = new JavaIntList();
        System.out.println(myList.size);
    }


}
