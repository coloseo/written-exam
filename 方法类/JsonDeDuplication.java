package com.greathzeze;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 *
 * @Date: 2021/2/27 17:33
 * @Author: Greathzeze
 */
class Person implements Serializable {
    private String name;
    private String serial;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(serial, person.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}

public class JsonDeDuplication {

    public static HashSet<Person> jsonDeDuplication(String jsonStr){
        List<Person> list= JSON.parseArray(jsonStr, Person.class);
        HashSet<Person> hashSet = new HashSet<>();
        for (Person person : list) {
            hashSet.add(person);
        }
        return hashSet;
    }

    public static void main(String[] args) {
        String s = "[{\n" +
                "    \"name\": \"张三\",\n" +
                "    \"serial\": \"0001\"\n" +
                "  }, {\n" +
                "    \"name\": \"李四\",\n" +
                "    \"serial\": \"0002\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五2\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }, {\n" +
                "    \"name\": \"小明\",\n" +
                "    \"serial\": \"005\"\n" +
                "  }, {\n" +
                "    \"name\": \"小张\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李2\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四2\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }]";
        System.out.println(jsonDeDuplication(s));
    }
}
