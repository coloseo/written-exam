package com.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        String s = " [{\"name\":\"张三\",\"serial\":\"0001\"},{\"name\":\"李四\",\"serial\":\"0002\"},{\"name\":\"王五\",\"serial\":\"0003\"},{\"name\":\"王五2\",\"serial\":\"0003\"},{\"name\":\"赵四\",\"serial\":\"0004\"},{\"name\":\"小明\",\"serial\":\"005\"},{\"name\":\"小张\",\"serial\":\"006\"},{\"name\":\"小李\",\"serial\":\"006\"},{\"name\":\"小李2\",\"serial\":\"006\"},{\"name\":\"赵四2\",\"serial\":\"0004\"}]";
        List<P> objects = JSON.parseArray(s, P.class);
        Map<String, P> map = new HashMap();
        for (P p : objects) {
            map.put(p.getSerial(), p);
        }
        objects.clear();
        for (P p : map.values()) {
            objects.add(p);
        }
        System.out.println(JSON.toJSONString(objects));
    }
}

class P {
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
    public String toString() {
        return super.toString();
    }


}