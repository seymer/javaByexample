import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name = "Alice";
        emp.address = "Phokka Kuan, Ambehta peer";
        emp.SSN = 12121212;
        emp.number = 101;

//        emp.mailCheck();

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
