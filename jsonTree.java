import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


// 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
public class jsonTree {
    public static JSONObject getJsontree(JSONArray json, JSONObject results){
        JSONArray tempJson = JSONArray.parseArray("[]");
        for(int i = 0;i < json.size();i++)
        {
            if(json.getJSONObject(i).get("parent").equals(results.get("code"))) {
                tempJson.add(json.getJSONObject(i));
            };
        }
        json.removeAll(tempJson);
        for(int i = 0;i < tempJson.size(); i ++) {
            getJsontree(json, tempJson.getJSONObject(i));
        }
        if(tempJson.size()!=0)
            results.put("children", tempJson);
        return results;
    }

    public static void main(String[] args) {
        String str = "[\n" +
                "    {\n" +
                "      \"code\": \"1\",\n" +
                "      \"name\": \"中国\",\n" +
                "      \"code\": \"110\",\n" +
                "      \"parent\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"2\",\n" +
                "      \"name\": \"北京市\",\n" +
                "      \"code\": \"110000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"3\",\n" +
                "      \"name\": \"河北省\",\n" +
                "      \"code\": \"130000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"4\",\n" +
                "      \"name\": \"四川省\",\n" +
                "      \"code\": \"510000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"5\",\n" +
                "      \"name\": \"石家庄市\",\n" +
                "      \"code\": \"130001\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"6\",\n" +
                "      \"name\": \"唐山市\",\n" +
                "      \"code\": \"130002\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"7\",\n" +
                "      \"name\": \"邢台市\",\n" +
                "      \"code\": \"130003\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"8\",\n" +
                "      \"name\": \"成都市\",\n" +
                "      \"code\": \"510001\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"9\",\n" +
                "      \"name\": \"简阳市\",\n" +
                "      \"code\": \"510002\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"10\",\n" +
                "      \"name\": \"武侯区\",\n" +
                "      \"code\": \"51000101\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"code\": \"11\",\n" +
                "      \"name\": \"金牛区\",\n" +
                "      \"code\": \"51000102\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    }\n" +
                "  ]";
        JSONArray json_str = JSONArray.parseArray(str);

        JSONObject parent = null;
        for (int i = 0; i < json_str.size(); i++) {
            if (json_str.getJSONObject(i).get("parent").equals("")){
                parent = json_str.getJSONObject(i);
            }
        }
        JSONObject result = getJsontree(json_str, parent);
        System.out.println(JSON.toJSONString(result));
    }
}
