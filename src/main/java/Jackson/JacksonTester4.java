package Jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JacksonTester4 {
    public static void main(String[] args) {
        try {
            JsonFactory jsonFactory = new JsonFactory();
            JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File("student.json"), JsonEncoding.UTF8);

            jsonGenerator.writeStartObject();

            // "name : "Mahesh Kumar"
            jsonGenerator.writeStringField("name", "mahesh kumar");

            jsonGenerator.writeNumberField("age", 21);

            jsonGenerator.writeBooleanField("verified", false);

            jsonGenerator.writeFieldName("marks");

            jsonGenerator.writeStartArray();

            jsonGenerator.writeNumber(100);
            jsonGenerator.writeNumber(90);
            jsonGenerator.writeNumber(85);

            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();
            jsonGenerator.close();

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> dataMap = mapper.readValue(new File("student.json"), Map.class);

            System.out.println("dataMap = " + dataMap);
            System.out.println("dataMap = " + dataMap.get("name"));
            System.out.println("dataMap = " + dataMap.get("age"));
            System.out.println("dataMap = " + dataMap.get("verified"));
            System.out.println("dataMap = " + dataMap.get("marks"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
