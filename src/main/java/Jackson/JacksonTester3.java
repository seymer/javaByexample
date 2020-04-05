package Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;

public class JacksonTester3 {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
            JsonNode rootNode = mapper.readTree(jsonString);

            JsonNode nameNode = rootNode.path("name");
            System.out.println("Name:" + nameNode.textValue());

            JsonNode ageNode = rootNode.path("age");
            System.out.println("age:" + ageNode.intValue());

            JsonNode verifiedNode = rootNode.path("verified");
            System.out.println("verified:" + (verifiedNode.booleanValue() ? "Yes" : "NO"));

            JsonNode marksNode = rootNode.path("marks");
            Iterator<JsonNode> iterator = marksNode.elements();
            System.out.println("marks [");

            while (iterator.hasNext()) {
                JsonNode marks = iterator.next();
                System.out.println(marks.intValue() + "");
            }

            System.out.println("]");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
