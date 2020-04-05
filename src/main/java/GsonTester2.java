import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class GsonTester2 {
    public static void main(String[] args) {
        GsonTester2 tester2 = new GsonTester2();
        try {
            Student student = new Student();
            student.setAge(10);
            student.setName("Jobs");
            tester2.writeJSON(student);
            Student student1 = tester2.readJSON();
            System.out.println("student1 = " + student1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeJSON(Student student) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("Student.json");
        writer.write(gson.toJson(student));
        writer.close();
    }

    private Student readJSON() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("student.json"));

        Student student = gson.fromJson(bufferedReader, Student.class);
        return student;
    }

}

