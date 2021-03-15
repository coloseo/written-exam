package com.itxs.coloseo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

import java.util.Map;


/**
 * 对下面的 json 字符串 serial 相同的进行去重
 * 利用map中key不重复的特点进行去重
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/15 15:26
 */
public class FourthQuestion {
    public static void main(String[] args) {
        String str="[{" +
                "    \"name\": \"张三\",\n" +
                "    \"serial\": \"0001\"\n" +
                "  }, {" +
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
        String result = JsonRemoveDuplicates(str);
        System.out.println(result);
    }

    /**
     * 将json字符串转进行去重
     * @param str
     * @return
     */
    public static String JsonRemoveDuplicates(String str){
        JSONArray jsonArray = JSONArray.parseArray(str);
        System.out.println(jsonArray);
        Map<String, String> filterMap = new HashMap<>();
        if (jsonArray != null && !jsonArray.isEmpty()) {
            jsonArray.forEach(object -> {
                if (object == null) {
                    return;
                }
                JSONObject jsonObject = (JSONObject) object;
                if (jsonObject.getString("serial") == null) {
                    return;
                }
                filterMap.put(jsonObject.getString("serial"), jsonObject.getString("name"));
            });
            System.out.println(filterMap);
            String jsonResult = JSON.toJSONString(filterMap);
            System.out.println("输出的结果是：" + filterMap);
            return jsonResult;
        }else{
            return null;
        }
    }
}
