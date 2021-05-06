import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 马强
 */


public class JsonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        String str = " [{\n" +
                "         \"name\": \"张三\",\n" +
                "         \"serial\": \"0001\"\n" +
                "         }, {\n" +
                "         \"name\": \"李四\",\n" +
                "         \"serial\": \"0002\"\n" +
                "         }, {\n" +
                "         \"name\": \"王五\",\n" +
                "         \"serial\": \"0003\"\n" +
                "         }, {\n" +
                "         \"name\": \"王五2\",\n" +
                "         \"serial\": \"0003\"\n" +
                "         }, {\n" +
                "         \"name\": \"赵四\",\n" +
                "         \"serial\": \"0004\"\n" +
                "         }, {\n" +
                "         \"name\": \"小明\",\n" +
                "         \"serial\": \"005\"\n" +
                "         }, {\n" +
                "         \"name\": \"小张\",\n" +
                "         \"serial\": \"006\"\n" +
                "         }, {\n" +
                "         \"name\": \"小李\",\n" +
                "         \"serial\": \"006\"\n" +
                "         }, {\n" +
                "         \"name\": \"小李2\",\n" +
                "         \"serial\": \"006\"\n" +
                "         }, {\n" +
                "         \"name\": \"赵四2\",\n" +
                "         \"serial\": \"0004\"\n" +
                "         }];";
        System.out.println(str);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList list = objectMapper.readValue(str, ArrayList.class);
        HashMap<String, String> map = new HashMap<>();
        Person person = new Person();
        for (Object o : list) {
            person = objectMapper.readValue(objectMapper.writeValueAsString(o), Person.class);
            map.put(person.getSerial(), person.getName());
        }
        System.out.println(objectMapper.writeValueAsString(map));
    }
}

class Person {
    private String name;
    private String serial;

    public Person() {
    }

    public Person(String name, String serial) {
        this.name = name;
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}

