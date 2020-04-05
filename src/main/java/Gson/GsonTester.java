package Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.Data;

import java.lang.reflect.Modifier;

public class GsonTester {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
//        builder.excludeFieldsWithoutExposeAnnotation();
        builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
        Gson gson = builder.create();

        Student student = new Student();
        student.setRollNo(1);
        student.setName("Mahesh Kumar");
        student.setVerified(true);
        student.setId(1);
        Student.className = "VI";

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}

@Data
class Student {
    @Expose
    private int rollNo;

    private String name;
    private boolean verified;
    private transient int id;
    public static String className;
}