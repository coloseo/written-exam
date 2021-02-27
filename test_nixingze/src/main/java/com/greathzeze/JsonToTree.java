package com.greathzeze;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
 * @Date: 2021/2/27 17:00
 * @Author: Greathzeze
 */
class City{
    private String id;
    private String name;
    private String code;
    private String parent;
    private List<City> Children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<City> getChildren() {
        return Children;
    }

    public void setChildren(List<City> children) {
        Children = children;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parent='" + parent + '\'' +
                ", Children=" + Children +
                '}';
    }
}

public class JsonToTree {


    /**
     * json转tree结构
     *
     * @param jsonStr
     * @return
     */
    public static List<City> jsonToTree(String jsonStr) {
        List<City> list =  JSONObject.parseArray(jsonStr,City.class);
        List<City> collect = list.stream().filter((city) -> {
            return "".equals(city.getParent());
        }).map(city -> {
            city.setChildren(getChildren(city, list));
            return city;
        }).collect(Collectors.toList());
        return collect;
    }

    private static List<City> getChildren(City root, List<City> all) {
        List<City> children = all.stream().filter((city) -> {
            return city.getParent().equals(root.getCode());
        }).map((city) -> {
            city.setChildren(getChildren(city, all));
            return city;
        }).collect(Collectors.toList());
        return children;
    }

    public static void main(String[] args) {
        String jsonStr = "[\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"中国\",\n" +
                "      \"code\": \"110\",\n" +
                "      \"parent\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"北京市\",\n" +
                "      \"code\": \"110000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"name\": \"河北省\",\n" +
                "      \"code\": \"130000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"name\": \"四川省\",\n" +
                "      \"code\": \"510000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"5\",\n" +
                "      \"name\": \"石家庄市\",\n" +
                "      \"code\": \"130001\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6\",\n" +
                "      \"name\": \"唐山市\",\n" +
                "      \"code\": \"130002\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"7\",\n" +
                "      \"name\": \"邢台市\",\n" +
                "      \"code\": \"130003\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"8\",\n" +
                "      \"name\": \"成都市\",\n" +
                "      \"code\": \"510001\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"9\",\n" +
                "      \"name\": \"简阳市\",\n" +
                "      \"code\": \"510002\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"10\",\n" +
                "      \"name\": \"武侯区\",\n" +
                "      \"code\": \"51000101\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"11\",\n" +
                "      \"name\": \"金牛区\",\n" +
                "      \"code\": \"51000102\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    }\n" +
                "]";
        System.out.println(jsonToTree(jsonStr));
    }
}
