package Jackson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonTester2 {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> stringObjectMap = new HashMap<String, Object>();
            int[] marks = {1, 2, 3};

            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");

            // Java Object
            stringObjectMap.put("student", student);
            // Java String
            stringObjectMap.put("name", "Mahesh Kumar");
            // Java Boolean
            stringObjectMap.put("verified", Boolean.FALSE);
            // Array
            stringObjectMap.put("marks", marks);

            objectMapper.writeValue(new File("Student.json"), stringObjectMap);

            stringObjectMap = objectMapper.readValue(new File("student.json"), Map.class);

            System.out.println(stringObjectMap.get("student"));
            System.out.println(stringObjectMap.get("name"));
            System.out.println(stringObjectMap.get("verified"));
            System.out.println(stringObjectMap.get("marks"));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
