package com.itxs.coloseo;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
 * 使用递归
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/15 16:56
 */
public class FifthQuestion {
    public static void main(String[] args) {
        String str="[\n" +
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
                "  ]";
        createTree(str);
    }

    public static void createTree(String str){
        JSONArray jsonArray = JSONArray.parseArray(str);
        List<Person> personList=new ArrayList<>();
        if (jsonArray != null && !jsonArray.isEmpty()) {
            jsonArray.forEach(object->{
                if (object==null){
                    return;
                }
                JSONObject jsonObject= (JSONObject) object;
                Person person = JSONObject.parseObject(jsonObject.toJSONString(), Person.class);
                personList.add(person);
            });
            System.out.println(personList);
        }
        //使用递归的方式将list转成树形
        //首先从list中拿去全部是顶级的父类
        List<Person> oneLevelTree=new ArrayList<>();
        for (int i=0;i<personList.size();i++){
            Person person = personList.get(i);
            if (person.parent.equals("")){
                oneLevelTree.add(person);
            }
        }
        //为一级树建立它的子树
        for (Person person : oneLevelTree) {
            getAllChildrens(person,personList);
        }
        System.out.println(oneLevelTree);
    }

    /**
     * @param parent 个人
     * @param allPerson 一级树形
     * @return
     */
    public static List<Person> getAllChildrens(Person parent,List<Person> allPerson){
        List<Person> sonList=new ArrayList<>();
        for (Person person1 : allPerson) {
            if (person1.parent.equals(parent.code)){
                parent.children.add(person1);
                sonList.add(person1);
            }
        }
        //继续递归
        for (Person son : sonList) {
            getAllChildrens(son,allPerson);
        }
        return sonList;
    }
}

class Person{
    public String parent;
    public int id;
    public String name;
    public String code;
    List<Person> children=new ArrayList<>();

    @Override
    public String toString() {
        return "Person{" +
                "parent='" + parent + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", children=" + children +
                '}';
    }


}
